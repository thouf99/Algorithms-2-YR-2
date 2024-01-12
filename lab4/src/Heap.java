import java.util.ArrayList;
import java.util.List;

class Heap {
    // public for JUnit testing purposes
    public ArrayList<Integer> array;
    public int heap_size;

    public Heap(int size) {
    }
    public Heap(List<Integer> source) {
        this(source, false);
    }
    public Heap(List<Integer> source, boolean incremental) {
        if (incremental){
            insert(1);
        }else {
            buildMaxHeap();
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }

    public static int parent(int index) {
        if (index <=2){
            return 0;
        } else {
            return (int) Math.floor((index-1)/2);
        }
    }
    public static int left(int index) {
        return (2*index)+1;
    }
    public static int right(int index) {
        return (2*index) + 2;
    }
    
    public void maxHeapify(int i) {
    }
    public void buildMaxHeap() {
    }
    public void insert(Integer k) {
    }
    public Integer maximum() {
        return 0;
    }
    public Integer extractMax() {
        return 0;
    }
}
