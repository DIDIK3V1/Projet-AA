package priorityQueue;

import graph.VertexCost;

public class VertexValue {
    private final int VERTEX;

    private VertexCost parentCost;

    /**
     * Construteur de VertexValue (Correspond a un arc contenant le sommet courant, le parent et le coût de celui ci)
     * @param x numero du sommet
     * @param p parent du sommet
     * @param c coût de l'arc
     */
    public VertexValue(int x, int p, int c){
        this.VERTEX = x;
        this.parentCost = new VertexCost(p,c);
    }

    /**
     * Accesseur du numero du sommet
     * @return VERTEX : int
     */
    public int getVertex(){
        return this.VERTEX;
    }

    /**
     * Accesseur de la valeur du parent de ce sommet
     * @return int
     */
    public int getParent() {
        return parentCost.getVERTEX();
    }


    public VertexCost getParentCost(){
        return this.parentCost;
    }

    /**
     * Accesseur du coût de cet Arc
     * @return int
     */
    public int getCost() {
        return parentCost.getCOST();
    }


    @Override
    public String toString(){
        return this.VERTEX + ' '+ this.parentCost.toString() ;
    }
    /**
     * Retourne une chaîne de caractère lisible par l'homme contenant le numero de sommet, le parent de ce sommet et le coût de l'arc
     * @return String
     */
    public String toReadableString(){

        return "( " + this.VERTEX + " - " + this.parentCost.toString() + " )";
    }

    /**
     * Met à jour le parent et le coût du sommet uniquement si la valeur actuelle du coût de l'arc est superieure à c
     * @param p parent
     * @param c coût
     */
    public void update(int p, int c){
        if(this.getCost()>c){
            this.parentCost=new VertexCost(p,c);
        }
    }

    public static void main(String[] args){
        VertexValue vv = new VertexValue(1,2,3);
        System.out.println(vv);
        vv.update(3,20);
        System.out.println(vv);
        vv.update(4,2);
        System.out.println(vv);
        System.out.println(vv.toReadableString());

    }




}
