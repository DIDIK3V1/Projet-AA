package priorityQueue;

public class Heap {
    private int[] tab;
    public Heap(int size){
        this.tab=new int[size];
    }

    public int getValInd(int i){
        if (i<this.tab.length)
            return tab[i];
        else throw new IndexOutOfBoundsException();
    }
    public void setValInd(int i, int val){
        if (i<this.tab.length){
            tab[i]=val;
            this.sort();
        }

        else throw new IndexOutOfBoundsException();
    }

    public void setTab(int[] t){
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
            int temp = this.tab[0];
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
                if(this.tab[rightInd] > this.tab[leftInd] && this.tab[rightInd]>this.tab[maxInd]){ //si la valeur a droite est plus grande que la valeur a gauche et a la racine
                    maxInd = rightInd;
                    modified=true;
                }
                else if(this.tab[leftInd] > this.tab[rightInd] && this.tab[leftInd] > this.tab[maxInd]){ //si la valeur a gauche est plus grande que la valeur a droite et a la racine
                    maxInd = leftInd;
                    modified=true;
                }
            }
            else if(this.tab[leftInd] > this.tab[maxInd]){ //si la valeur a droite n'existe pas et que la valeur a gauche est plus grande que la valeur à la racine
                    maxInd = leftInd;
                    modified=true;
            }

        }
        else if(rightInd<n){ //si la valeur a gauche n'existe pas et que la valeur a droite est plus grande que la valeur a la racine
            if(this.tab[rightInd] > this.tab[maxInd]){
                maxInd = rightInd;
                modified=true;
            }

        }

        if (modified) { //en cas de modification des valeurs d'indice, remplacement des valeurs aux indices et rééexution du code
            int tmp = tab[i];
            this.tab[i] = tab[maxInd];
            this.tab[maxInd] = tmp;
            reorganize_from_top(n, maxInd);
        }
    }

    // Function to print an array
    public void printArray() {
        for (int j : this.tab) System.out.print(j + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = { 1, 12, 9, 5, 6, 10 };

        Heap hs = new Heap(arr.length);
        hs.setTab(arr);

        System.out.println("Sorted array is");
        hs.printArray();
    }

}
