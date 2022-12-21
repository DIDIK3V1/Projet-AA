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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("( ").append(this.VERTEX).append(" - ").append(this.parent).append(" cout : ").append(this.cost).append(" )  ");
        return sb.toString();
    }
    public void update(int p, int c){
        if(this.cost > c){
            this.parent = p;
            this.cost = c;
        }
    }
}
