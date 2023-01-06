package priorityQueue;

public class Heap {
    private VertexValue[] tab;

    /**
     * Constructeur de tas(Heap)
     * @param size taille du tas
     */
    public Heap(int size){
        this.tab= new VertexValue[size];
    }

    /**
     * Retourne la VertexValue a l'indice i
     * @param i index de la valeur
     * @return VertexValue
     */
    public VertexValue getValInd(int i){
        if (i<this.tab.length)
            return tab[i];
        else throw new IndexOutOfBoundsException();
    }
    /**
     * ajoute val a l'indice i et trie
     * @param i index de la valeur a modifier
     * @param val valeur à ajouter
     */
    public void setValInd(int i, VertexValue val){
        if (i<this.tab.length){
            tab[i]=val;
            this.sort();
        }
        else throw new IndexOutOfBoundsException();
    }

    /**
     * ajoute val a l'indice i uniquement si le vertex n'est pas dans la liste, sinon modifie la valeur existante dans la file et trie dans les deux cas
     * @param i index de la valeur a modifier si le sommet n'existe pas dans la liste
     * @param val valeur a ajouter qui modifiera les valeurs du tas
     */
    public void setOrModifVal(int i, VertexValue val){
        boolean exist = false;
        for(VertexValue vv : this.tab){
            if(vv.getVertex() == val.getVertex()){
                exist = true;
                if(vv.getCost()>val.getCost()){
                    vv.update(val.getParent(),val.getCost());
                    this.sort();
                }
                break;
            }
        }
        if(!exist){
            this.setValInd(i, val);
        }

    }

    /**
     * modifie le tableau de VertexValue et le trie
     * @param t tableau de VertexValue
     */
    public void setTab(VertexValue[] t){
        if (t.length==this.tab.length){
            tab=t;
            this.sort();
        }
        else throw new IndexOutOfBoundsException();
    }

    /**
     * trie en utilisant l'olgorithme du tri par tas
     */
    private void sort() {
        int n = this.tab.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            reorganize_from_top(n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            VertexValue temp = this.tab[0];
            this.tab[0] = this.tab[i];
            this.tab[i] = temp;
            reorganize_from_top( i, 0);
        }
    }


    /**
     * Trie le tas en considèrant le tableau comme un arbre
     * @param n taille du tas a trier
     * @param i index de la racine de l'arbre
     */
    void reorganize_from_top(int n, int i) {
        int maxInd = i; //index de la racine de l'arbre
        int leftInd = (2 * i) + 1; //index du fils gauche (+1 car en java les tableaux commencent a zero)
        int rightInd = (2 * i) + 2; //index du fils droit (+1 car en java les tableaux commencent a zero)
        boolean modified =false;

        if(leftInd<n ){
            if(rightInd<n){
                if(this.tab[rightInd].getCost() >= this.tab[leftInd].getCost() && this.tab[rightInd].getCost()>this.tab[maxInd].getCost()){ //si la valeur a droite est plus grande que la valeur a gauche et a la racine
                    maxInd = rightInd;
                    modified=true;
                }
                else if(this.tab[leftInd].getCost() > this.tab[rightInd].getCost() && this.tab[leftInd].getCost() > this.tab[maxInd].getCost()){ //si la valeur a gauche est plus grande que la valeur a droite et a la racine
                    maxInd = leftInd;
                    modified=true;
                }


            }
            else if(this.tab[leftInd].getCost() > this.tab[maxInd].getCost()){ //si la valeur a droite n'existe pas et que la valeur a gauche est plus grande que la valeur à la racine
                    maxInd = leftInd;
                    modified=true;

            }

        }
        else if(rightInd<n){ //si la valeur a gauche n'existe pas et que la valeur a droite est plus grande que la valeur a la racine
            if(this.tab[rightInd].getCost() >this.tab[maxInd].getCost()){
                maxInd = rightInd;
                modified=true;
            }

        }


        if (modified) { //en cas de modification des valeurs d'indice, remplacement des valeurs aux indices et rééexution du code
            VertexValue tmp = tab[i];
            this.tab[i] = tab[maxInd];
            this.tab[maxInd] = tmp;
            reorganize_from_top(n, maxInd);
        }
    }

    /**
     * retourne dans une chaine de caractère le tas jusqu'a endval;
     * @param endval valeur de fin de l'affichage
     * @return String
     */

    public String toString(int endval) {
        if (endval>this.tab.length){
            endval= this.tab.length;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<endval; i++){
            sb.append(this.tab[i].toString() ).append( " ");
        }
        sb.append('\n');
        return sb.toString();
    }

    /**
     * Fonction main de tests
     * @param args arguments du main
     */
    public static void main(String[] args) {
        VertexValue vv1 = new VertexValue(1,2,1);
        VertexValue vv2 = new VertexValue(2,6, 13);
        VertexValue vv3 = new VertexValue(3, 1, 1073741823);
        VertexValue vv4 = new VertexValue(4, 2, 5);
        VertexValue vv5 = new VertexValue(5, 6, 6);
        VertexValue vv6 = new VertexValue(6, 3, 9);
        VertexValue[] tab = {vv1,vv2,vv3,vv4,vv5,vv6};

        Heap h = new Heap(tab.length);
        h.setTab(tab);
        VertexValue vv7 = new VertexValue(7, 6, 11);
        VertexValue vv8 = new VertexValue(8, 2, 8);
        h.setValInd(2,vv7);
        h.setValInd(2,vv8);
        System.out.println(h.toString(tab.length));

        VertexValue vv9 = new VertexValue(9, 5, 8);
        h.setValInd(4,vv9);
        System.out.println(h.toString(tab.length));

    }

}
