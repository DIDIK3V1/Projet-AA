package Graph;

public class Graph {
    private final int size;
    private int[] vertex;
    private int[][] vertexSuccessor;

    public Graph(int[] file){

        this.size = 0;
    }

    public void setAdjacencyList(int x, int[] neighborhood) {
        this.isVertex(x);
        int size = neighborhood.length;
        int[] newNeighborh = new int[size];
        System.arraycopy(neighborhood, 0, newNeighborh, 0, size);
        this.adjacencyList[x-1] = newNeighborh;
    }
}
