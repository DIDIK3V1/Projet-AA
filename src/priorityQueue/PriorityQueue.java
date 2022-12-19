package priorityQueue;
import java.lang.Math;
public class PriorityQueue {
    private Heap heaptab;
    private final int MAX_SIZE;
    int last;
    public PriorityQueue(int maxSize){//fonction CREATE
        MAX_SIZE=maxSize;
        heaptab = new Heap(maxSize);
        Empty();
    }
    public void Empty(){
        int[] tab = new int[MAX_SIZE];
        this.last=0;
        //création d'un tableau "vide" de priorité maximale (ne change pas l'ordre des elements après le last)
        for(int i=0; i<MAX_SIZE;i++){
            tab[i]=(int)Math.pow(2,30)-1;
        }
        heaptab.setTab(tab);
    }

    public void Add(int val){
        if (this.last<MAX_SIZE){
            this.last++;
            heaptab.setValInd(this.last,val);
        }else throw new IndexOutOfBoundsException();
    }
    public int Head(){
        return this.heaptab.getValInd(0);
    }

    public int Drop(){
        if(this.last>=0){
            int val = heaptab.getValInd(0);
            heaptab.setValInd(0,(int) Math.pow(2,30)-1);
            this.last--;
            return val;
        }else throw new IndexOutOfBoundsException();

    }

    public void Extract(PriorityQueue Y){
        if (last>=0){
            int val = heaptab.getValInd(0);
            heaptab.setValInd(0,(int) Math.pow(2,30)-1);
            this.last--;
            Y.Add(val);
        }else throw new IndexOutOfBoundsException();

    }

    public void printArray() {
        heaptab.printArray();
    }

    public int Count(){
        return this.last;
    }
    public static void main(String[] args) {
        int[] tab = { 1, 12, 9, 5, 6, 10 };
        PriorityQueue pq = new PriorityQueue(tab.length);
        PriorityQueue pq2 = new PriorityQueue(tab.length);
        pq.printArray();
        pq.Add(12);
        pq.printArray();
        pq.Add(1);
        pq.printArray();
        pq.Add(3);
        pq.printArray();
        int val = pq.Head();
        System.out.println(val);
        pq.Drop();
        int val2 = pq.Head();
        System.out.println(val2);
        pq.printArray();
        pq.Extract(pq2);
        pq2.printArray();
        pq.printArray();


    }
}
