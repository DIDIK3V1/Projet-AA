package Graph;

import java.util.Scanner;

public class Graph {
    private final int SIZE;
    private int[] vertex;
    private ParentCost[][] vertexSuccessor;

    public Graph(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        this.SIZE = n;
        this.vertex = new int[n];
        //
        this.vertexSuccessor = new ParentCost[n][n];
        for(int i = 0; i < this.SIZE; i++){
            n = scan.nextInt();
            this.vertex[i] = n;
            n = scan.nextInt();
            int j = 0;
            while(n > 0){
                int p = n;
                n = scan.nextInt();
                int c = n;
                this.vertexSuccessor[i][j] = new ParentCost(p,c);
                j++;
            }
        }
    }

    /*public void setAdjacencyList(int x, int[] neighborhood) {
        this.isVertex(x);
        int size = neighborhood.length;
        int[] newNeighborh = new int[size];
        System.arraycopy(neighborhood, 0, newNeighborh, 0, size);
        this.adjacencyList[x-1] = newNeighborh;
    }*/
}
