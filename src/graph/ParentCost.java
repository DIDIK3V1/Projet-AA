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
    public String toReadableString(){
        StringBuilder sb = new StringBuilder();

        if (PARENT==0){
           sb.append("Source") ;
        }
        else if (PARENT == -1) {
            sb.append("Parent : Aucun, Coût : Infini");
        }
        else {
            sb.append("Parent : ").append(PARENT).append(", Coût : ").append(COST);
        }

        return sb.toString();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        if (PARENT==0){
            sb.append(COST).append(" _") ;
        }
        else if (PARENT == -1) {
            sb.append(COST).append(" _");
        }
        else {
            sb.append(COST).append(" ").append(PARENT);
        }

        return sb.toString();
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

