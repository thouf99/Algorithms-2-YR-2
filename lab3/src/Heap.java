import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Heap {
    // public for JUnit testing purposes
    public ArrayList<Integer> array = new ArrayList<>();
    public int heap_size;

    public Heap(int size) {
        array = new ArrayList<>(size);
        heap_size = size;
    }

    public Heap(List<Integer> source) {
        this(source, false);
    }

    public Heap(List<Integer> source, boolean incremental) {
        if(incremental){
            for(int a = 0; a<source.size(); a++){
                System.out.println("Input array: " + source + " and incremental is true");
                insert(source.get(a));
            }
        } else {
            System.out.println("Input array: " + source + " and incremental is false");
            array.addAll(source);
            heap_size = source.size();
            buildMaxHeap();
        }
    }

    public static int parent(int index) {
        return ((index-1)/2);
    }
    public static int left(int index) {
        return ((2*index)+1);
    }
    public static int right(int index) {
        return (2*(index+1));
    }

    public void maxHeapify(int i) {
        int biggest = i;
        int left = left(i);
        int right = right(i);
        if(left<array.size() && array.get(left)>array.get(biggest)) {
            biggest = left;
        }
        if(right<array.size() && array.get(right)>array.get(biggest)){
            biggest = right;
        }
        if(biggest != i){
            int swap = array.get(i);
            array.set(i, array.get(biggest));
            array.set(biggest, swap);
            maxHeapify(biggest);
        }
    }

    public void buildMaxHeap() {
        for(int b =(heap_size / 2) - 1; b>=0; b--){
            maxHeapify(b);
        }
    }

    public void insert(Integer k) {
        int position = heap_size;
        array.add(k);
        heap_size++;
        while (position>0 && array.get(parent(position))<array.get(position)){
            Collections.swap(array, parent(position), position);
            position=parent(position);
        }
    }

    public Integer maximum() {
        return array.get(0);
    }
    public Integer extractMax() {
        int max = Collections.max(array);
        array.set(0, array.get(array.size()-1));
        array.remove(array.size()-1);
        heap_size--;
        maxHeapify(0);
        return max;
    }

    public ArrayList<Integer> sort(){
        ArrayList<Integer> arr = (ArrayList<Integer>)array.clone();
        Collections.sort(arr);
        return arr;
    }
}
