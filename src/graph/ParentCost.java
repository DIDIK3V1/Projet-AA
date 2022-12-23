package graph;

public class ParentCost {
    private final int PARENT;
    private final int COST;

    /**
     * Constructeur du couple (parent * coût)
     * @param p parent
     * @param c coût
     */
    public ParentCost(int p, int c){
        this.PARENT = p;
        this.COST = c;
    }

    /**
     * Accesseur sur le coût d'un arc
     * @return COST : int
     */
    public int getCOST() {
        return COST;
    }

    /**
     * Accesseur sur le parent (origine) de l'arc
     * @return PARENT : int
     */
    public int getPARENT() {
        return PARENT;
    }

    /**
     * Transforme le couple en Chaîne de caractère
     * @return String
     */
    @Override
    public String toString(){

        return "Parent : " + PARENT + " Coût " + COST;
    }

    /**
     * Fonction main de tests
     * @param args arguments du main
     */
    public static void main(String[] args){
        ParentCost pc = new ParentCost(1,3);
        System.out.println(pc);
    }
}

