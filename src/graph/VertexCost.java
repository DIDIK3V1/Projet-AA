package graph;

public class VertexCost {
    private final int VERTEX;
    private final int COST;

    /**
     * Constructeur du couple (parent * coût)
     * @param p parent
     * @param c coût
     */
    public VertexCost(int p, int c){
        this.VERTEX = p;
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
    public int getVERTEX() {
        return VERTEX;
    }

    /**
     * Transforme le couple en Chaîne de caractère
     * @return String
     */
    public String toReadableString(){
        StringBuilder sb = new StringBuilder();

        if (VERTEX ==0){
           sb.append("Source") ;
        }
        else if (VERTEX == -1) {
            sb.append("Parent : Aucun, Coût : Infini");
        }
        else {
            sb.append("Parent : ").append(VERTEX).append(", Coût : ").append(COST);
        }

        return sb.toString();
    }



    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        if (VERTEX ==0){
            sb.append(COST).append(" _") ;
        }
        else if (VERTEX == -1) {
            sb.append(COST).append(" _");
        }
        else {
            sb.append(COST).append(" ").append(VERTEX);
        }

        return sb.toString();
    }

    /**
     * Fonction main de tests
     * @param args arguments du main
     */
    public static void main(String[] args){
        VertexCost pc = new VertexCost(1,3);
        System.out.println(pc);
    }
}

