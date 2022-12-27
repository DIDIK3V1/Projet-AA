package priorityQueue;
import java.lang.Math;

public class PriorityQueue {
    private final Heap HEAP_TAB;
    private final int MAX_SIZE;
    int last;

    /**
     * constructeur de la file a priorité
     * @param maxSize taille maximale de la file
     *
     */
    public PriorityQueue(int maxSize){//fonction CREATE
        MAX_SIZE=maxSize;
        HEAP_TAB = new Heap(maxSize);
        Empty();
    }

    /**
     * Crée une file a priorité vide, mets toutes les priorités a (2^30)-1 pour accepter des priorité plus faibles
     */
    private void Empty(){
        VertexValue[] tab = new VertexValue[MAX_SIZE];
        this.last=0;
        VertexValue vv = new VertexValue((int)Math.pow(2,30)-1,(int)Math.pow(2,30)-1,(int)Math.pow(2,30)-1);
        //création d'un tableau "vide" de priorité maximale (ne change pas l'ordre des elements après le last)
        for(int i=0; i<MAX_SIZE;i++){
            tab[i]=vv;
        }
        HEAP_TAB.setTab(tab);
    }

    /**
     * Vérifie si une file a priorité est vide
     */
    public boolean isEmpty(){
        return (this.Count()==0);
    }

    /**
     * Ajoute dans le heaptab une valeur, peu importe si le sommet existe dans la file ou non
     * @param val valeur à ajouter
     */
    public void Add(VertexValue val){
        if (this.last<MAX_SIZE){
            this.last++;
            HEAP_TAB.setValInd(this.last,val);
        }else throw new IndexOutOfBoundsException();
    }

    /**
     * Parcoure la file, si le sommet existe alors on modifie le parent et le coût uniquement si ceux de la valeur trouvée sont inférieure à la valeur qu'on veut rentrer, si la valeur existe pas alors on l'insère
     * @param val valeur à ajouter
     */
    public void AddModify(VertexValue val){
        if (this.last<MAX_SIZE){
            this.last++;
            HEAP_TAB.setOrModifVal(this.last,val);
        }else throw new IndexOutOfBoundsException();

    }

    /**
     * Retourne la tete de la file
     * @return Heap
     */
    public VertexValue Head(){
        return this.HEAP_TAB.getValInd(0);
    }

    /**
     * Retourne et supprime la tete de la file
     * @return Heap
     */

    public VertexValue Drop(){
        if(this.last>=0){
            VertexValue val = HEAP_TAB.getValInd(0);
            VertexValue vv = new VertexValue((int)Math.pow(2,30)-1,(int)Math.pow(2,30)-1,(int)Math.pow(2,30)-1);
            HEAP_TAB.setValInd(0,vv);
            this.last--;
            return val;
        }else throw new IndexOutOfBoundsException();

    }

    /**
     * Ajoute dans une autre file a priorité la valeur à la tête en la supprimant de la première.
     * @param Y liste a priorité qui contiendra la valeur a la tete de la premère liste
     */

    public void Extract(PriorityQueue Y){
        Y.Add(this.Drop());
    }

    /**
     * Retourne dans une chaîne de caractère les valeurs entrées de la file à priorité
     */
    @Override
    public String toString() {
        return(HEAP_TAB.toString(this.last));
    }

    /**
     * Retourne la taille de la file a priorité (uniquement le nombre de valeurs entrées"
     * @return int
     */
    public int Count(){
        return this.last;
    }

    /**
     * Fonction main de tests
     * @param args arguments en ligne de commande
     */
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(6);
        PriorityQueue pq2 = new PriorityQueue(6);

        VertexValue vv1 = new VertexValue(1,2,12);
        VertexValue vv2 = new VertexValue(2,3, 1);
        VertexValue vv3 = new VertexValue(3, 1, 3);

        System.out.println(pq);
        pq.Add(vv1);
        System.out.println(pq);
        pq.Add(vv2);
        System.out.println(pq);
        pq.Add(vv3);
        System.out.println(pq);


        System.out.println(pq.Count());
        System.out.println("Modification de la liste ");
        VertexValue vv4 = new VertexValue(3, 2, 1);
        pq.AddModify(vv4);
        System.out.println(pq);

        VertexValue val = pq.Head();
        System.out.println(val);

        pq.Drop();
        VertexValue val2 = pq.Head();
        System.out.println(val2);
        System.out.println(pq);
        pq.Extract(pq2);
        System.out.println(pq2);
        System.out.println(pq);






    }
}
