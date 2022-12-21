package priorityQueue;

public class VertexValue {
    private final int VERTEX;
    private int parent;
    private int cost;

    public VertexValue(int x, int p, int c){
        this.VERTEX = x;
        this.parent = p;
        this.cost = c;
    }

    public int getVertex(){
        return this.VERTEX;
    }

    public int getParent() {
        return parent;
    }

    public int getCost() {
        return cost;
    }

    public void update(int p, int c){
        if(this.cost > c){
            this.parent = p;
            this.cost = c;
        }
    }
}
