package Graph;

public class ParentCost {
    private final int PARENT;
    private final int COST;

    public ParentCost(int p, int c){
        this.PARENT = p;
        this.COST = c;
    }

    public int getCOST() {
        return COST;
    }

    public int getPARENT() {
        return PARENT;
    }
}
