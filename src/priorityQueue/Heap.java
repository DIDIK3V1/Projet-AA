package priorityQueue;

public class Heap {
    private VertexValue[] tab;
    public Heap(int size){
        this.tab= new VertexValue[size];
    }

    public VertexValue getValInd(int i){
        if (i<this.tab.length)
            return tab[i];
        else throw new IndexOutOfBoundsException();
    }
    public void setValInd(int i, VertexValue val){
        if (i<this.tab.length){
            tab[i]=val;
            this.sort();
        }
        else throw new IndexOutOfBoundsException();
    }
    public VertexValue[] getTab(){
        return this.tab;
    }

    public void setTab(VertexValue[] t){
        if (t.length==this.tab.length){
            tab=t;
            this.sort();
        }
        else throw new IndexOutOfBoundsException();
    }
    private void sort() {
        int n = this.tab.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            reorganize_from_top(n, i);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            VertexValue temp = this.tab[0];
            this.tab[0] = this.tab[i];
            this.tab[i] = temp;

            reorganize_from_top( i, 0);
        }
    }



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

    public void printArray(int endval) {
        for (int i=0; i<endval; i++){
            System.out.print( this.tab[i].toString() + " ");
        }
        System.out.println();
    }
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
        h.printArray(tab.length);

        VertexValue vv9 = new VertexValue(9, 5, 8);
        h.setValInd(4,vv9);
        h.printArray(tab.length);

    }

}
