package priorityQueue;
import java.lang.Math;
import java.util.Vector;

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
        VertexValue[] tab = new VertexValue[MAX_SIZE];
        this.last=0;
        VertexValue vv = new VertexValue(0,0,(int)Math.pow(2,30)-1);
        //création d'un tableau "vide" de priorité maximale (ne change pas l'ordre des elements après le last)
        for(int i=0; i<MAX_SIZE;i++){
            tab[i]=vv;
        }
        heaptab.setTab(tab);
    }

    public void Add(VertexValue val){
        if (this.last<MAX_SIZE){
            this.last++;
            heaptab.setValInd(this.last,val);
        }else throw new IndexOutOfBoundsException();
    }
    public VertexValue Head(){
        return this.heaptab.getValInd(0);
    }

    public VertexValue Drop(){
        if(this.last>=0){
            VertexValue val = heaptab.getValInd(0);
            VertexValue vv = new VertexValue(0,0,(int)Math.pow(2,30)-1);
            heaptab.setValInd(0,vv);
            this.last--;
            return val;
        }else throw new IndexOutOfBoundsException();

    }

    public void Extract(PriorityQueue Y){
        if (last>=0){
            VertexValue val = heaptab.getValInd(0);
            VertexValue vv = new VertexValue(0,0, (int) Math.pow(2,30)-1);
            heaptab.setValInd(0,vv);
            this.last--;
            Y.Add(val);
        }else throw new IndexOutOfBoundsException();

    }

    public void printArray() {
        heaptab.printArray(this.last);
    }

    public int Count(){
        return this.last;
    }
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(6);
        PriorityQueue pq2 = new PriorityQueue(6);

        VertexValue vv1 = new VertexValue(1,2,12);
        VertexValue vv2 = new VertexValue(2,3, 1);
        VertexValue vv3 = new VertexValue(3, 1, 3);
        pq.printArray();
        pq.Add(vv1);
        pq.printArray();
        pq.Add(vv2);
        pq.printArray();
        pq.Add(vv3);
        pq.printArray();

        VertexValue val = pq.Head();
        System.out.println(val.toString());
        pq.Drop();
        VertexValue val2 = pq.Head();
        System.out.println(val2.toString());
        pq.printArray();
        pq.Extract(pq2);
        pq2.printArray();
        pq.printArray();


    }
}
