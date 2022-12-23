package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
    private final int SIZE;
    private final int[] VERTEX;
    private final ParentCost[][] VERTEX_SUCCESSOR;

    /**
     * Constructeur de Graph
     * @param scan : scanner de fichier ou de la console
     */
    public Graph(Scanner scan){
        int n = scan.nextInt();
        this.SIZE = n;
        this.VERTEX = new int[this.SIZE];
        this.VERTEX_SUCCESSOR = new ParentCost[n][n];
        this.initVertexSuccessor(scan);


    }

    /**
     * Initialisateur de la liste d'adjacence (vertexsuccessor)
     * @param scan scanner de fichier ou de la console
     */
    private void initVertexSuccessor(Scanner scan) {
        int n;
        for(int i = 0; i < this.SIZE; i++) {
            int prevn = i - 1;
            n = scan.nextInt();

            if (n > prevn + 2 && !(prevn <= 0)) { //si on a un sommet isolé
                while (n > prevn + 2) {
                    this.VERTEX[i] = prevn; //ce vertex n'a pas de parents ni de coût
                    ParentCost pc = new ParentCost(-1 /*valeur impossible*/, (int) Math.pow(2, 30) - 1/*coût maximal pour signifier qu'il est inatégnable*/);
                    this.VERTEX_SUCCESSOR[i][0] = pc;
                    i++;
                    prevn++;
                }

            }
            this.VERTEX[i] = n;
            n = scan.nextInt();
            int j = 0;
            while (n > 0) {
                int p = n;
                n = scan.nextInt();
                int c = n;
                n = scan.nextInt();
                ParentCost pc = new ParentCost(p, c);
                this.VERTEX_SUCCESSOR[i][j] = pc;
                j++;
            }
        }
    }
/*
    public priorityList Dijkstra(PriorityList s){
        s.add(s,_,0) //ajout de s dans la file à prio
        A<- Nil
        for x in v x != s
        //S.add(x,_,infinite)
        c(x) <- infinite
        while (!Empty(S))
            x = A.process
        A.add(x)
        for v in G+(x.sommet)
                modify(v,x.sommet,x.cout + cout(x.sommet,v))
        reorganize(A) //pour avoir les sommet dans l'ordre
        return A
    }

 */

    /**
     * Renvoie la chaîne de caractère représentant le graphe
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<this.SIZE; i++){
            int j=0;
            while(VERTEX_SUCCESSOR[i][j]!= null){
                sb.append("Sommet : ").append( VERTEX[i] ).append(' ').append(VERTEX_SUCCESSOR[i][j].toString()).append('\n');
                j++;
            }
        }
        return sb.toString();
    }

    /**
     * Fonction main de tests
     * @param args arguments du main
     */
    public static void main(String[] args){
        File file = new File("graph.txt");
        Scanner scan;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        }

        Graph g = new Graph(scan);
        System.out.println(g);

    }


}
