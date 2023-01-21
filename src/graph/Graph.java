package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import priorityQueue.*;

public class Graph {
    private final int SIZE;
    private final VertexCost[][] VERTEX_SUCCESSOR;

    /**
     * Constructeur de Graph
     * @param scan : scanner de fichier ou de la console
     */
    public Graph(Scanner scan){
        int n = scan.nextInt();
        this.SIZE = n;
        this.VERTEX_SUCCESSOR = new VertexCost[n][n];
        this.initVertexSuccessor(scan);


    }

    /**
     * Initialisateur de la liste d'adjacence (vertexsuccessor)
     * @param scan scanner de fichier ou de la console
     */
    private void initVertexSuccessor(Scanner scan) {
        int n =0;
        for(int i = 0; i < this.SIZE; i++) {
            int prevn = i;
            try {
                n = scan.nextInt();
            }catch (NoSuchElementException e){
                this.VERTEX_SUCCESSOR[i][0] = null;
            }

            if (n > prevn + 1 && !(prevn <= 0)) { //si on a un sommet isolé
                while (n > prevn + 1) {
                    this.VERTEX_SUCCESSOR[i][0] = null;
                    i++;
                    prevn++;
                }
            }
            try {
                n = scan.nextInt();
            }catch (NoSuchElementException e){
                this.VERTEX_SUCCESSOR[i][0] = null;
            }
            int j = 0;
            while (n > 0) {
                int p = n;
                n = scan.nextInt();
                int c = n;
                n = scan.nextInt();
                VertexCost pc = new VertexCost(p, c);
                this.VERTEX_SUCCESSOR[i][j] = pc;
                j++;
            }
        }
    }

    /**
     * Effectue l'algorithme de Dijkstra sur le graphe
     * @param s Sommet original
     * @return tableau de VertexCost
     */
    public VertexCost[] Dijkstra(int s){
        PriorityQueue pq = new PriorityQueue(this.SIZE);
        pq.Add(new VertexValue(s,0,0)); //ajout de s dans la file à prio
        VertexCost[] result = new VertexCost[this.SIZE];
        for(int i = 0; i < this.SIZE; i++){
            result[i] = new VertexCost(-1, (int)Math.pow(2,30)-1); //tout les sommets n'ont donc par défaut aucun chemin vers s
        }

        while (!pq.isEmpty()){
            VertexValue x = pq.Drop();
            if(x != null){
                result[x.getVertex()-1] = x.getParentCost();
                for(int j = 0; j < this.SIZE; j++){
                    VertexCost succ = this.VERTEX_SUCCESSOR[x.getVertex()-1][j];

                    if(succ != null){
                        if(result[succ.getVERTEX()-1].getVERTEX() == -1){
                            pq.AddModify(new VertexValue(succ.getVERTEX(), x.getVertex(), succ.getCOST()+x.getCost()));
                        }
                        
                    }else {
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Retourne une chaîne de caractère qui contient les valeurs du tableau de VectexCost
     * @param pctab tableau de couple sommet/cout
     * @return String
     */
    public String vertexCostTabToReadableString(VertexCost[] pctab){
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<pctab.length; i++){
            sb.append(i+1).append(" ").append(pctab[i].toReadableString()).append('\n');
        }
        return sb.toString();
    }

    public String vectexCostTabToString(VertexCost[] pctab){
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<pctab.length; i++){
            sb.append(i+1).append(" (").append(pctab[i].toString()).append(")").append('\n');
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
                sb.append("Sommet : ").append( i+1 ).append(' ').append(VERTEX_SUCCESSOR[i][j].toString()).append('\n');
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

        VertexCost[] pctab = g.Dijkstra(5);

        System.out.println(g.vertexCostTabToReadableString(pctab));
        System.out.println(g.vectexCostTabToString(pctab));

    }


}
