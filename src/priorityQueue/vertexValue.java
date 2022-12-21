package priorityQueue;

public class vertexValue {
    private final int VERTEX;
    private int parent;
    private int cost;

    public vertexValue(int x, int p, int c){
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

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void update(int p, int c){
        if(this.cost > c){
            this.parent = p;
            this.cost = c;
        }
    }
}
