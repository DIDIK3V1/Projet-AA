package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import priorityQueue.*;

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
            for(int k = j; j<this.SIZE; j++){
                this.VERTEX_SUCCESSOR[i][k] = new ParentCost(-1, (int)Math.pow(2,30)-1); // on remplit le reste du tableau de valeurs
            }
        }
    }

    /**
     * Effectue l'algorithme de Dijkstra sur le graphe
     * @param s Sommet original
     * @return tableau de VertexValue
     */
    public ParentCost[] Dijkstra(int s){
        PriorityQueue pq = new PriorityQueue(this.SIZE);
        pq.Add(new VertexValue(s,0,(int)Math.pow(2,30)-1)); //ajout de s dans la file à prio
        ParentCost[] A = new ParentCost[this.SIZE];
        //peut être pas necessaire
        for(int i = 0; i < this.SIZE; i++){
            A[i] = new ParentCost(-1, (int)Math.pow(2,30)-1); //tout les sommets n'ont donc par défaut aucun chemin vers s
        }

        while (!pq.isEmpty()){
            VertexValue x = pq.Drop();
            A[x.getVertex()-1] = x.getParentCost();
            for(int j = 0; j < this.SIZE; j++){
                ParentCost succ = this.VERTEX_SUCCESSOR[x.getVertex()-1][j];


                if(succ.getPARENT() != -1){
                    System.out.print(x.getVertex() + " ");
                    System.out.println(succ);
                    pq.Add(new VertexValue(succ.getPARENT(), x.getVertex(), succ.getCOST()));
                }else {
                    break;
                }
            }
        }
        return A;
    }

    /**
     * Retourne une chaîne de caractère qui contient les valeurs du tableau de ParentCost
     * @param pctab tableau de couple parent/cout
     * @return String
     */
    public static String parentCostTabToReadableString(ParentCost[] pctab){
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<pctab.length; i++){
            sb.append(i).append(" ").append(pctab[i].toReadableString()).append('\n');
        }
        return sb.toString();
    }

    public static String parentCostTabToString(ParentCost[] pctab){
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<pctab.length; i++){
            sb.append(i).append(" (").append(pctab[i].toString()).append(")").append('\n');
        }
        return sb.toString();
    }

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
        //System.out.println(g);


        //g.Dijkstra(21);

        ParentCost[] pctab = new ParentCost[5];
        pctab[0]=new ParentCost(0,0);//sommet source == 1
        pctab[1]=new ParentCost(4,5);//sommet 2
        pctab[2]=new ParentCost(-1,(int)Math.pow(2,30)-1);//sommet 3 isolé
        pctab[3]=new ParentCost(1,3);//sommet 4
        pctab[4]=new ParentCost(4,4);//sommet 5
        System.out.println(Graph.parentCostTabToReadableString(pctab));
        System.out.println(Graph.parentCostTabToString(pctab));
    }


}
