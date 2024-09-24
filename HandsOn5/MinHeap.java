import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {
    private List<T> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) >> 1; 
    }

    private int leftChild(int i) {
        return (i << 1) + 1;  
    }

    private int rightChild(int i) {
        return (i << 1) + 2; 
    }

    public void buildMinHeap(List<T> items) {
        heap = new ArrayList<>(items);
        for (int i = parent(heap.size() - 1); i >= 0; i--) {
            minHeapify(i);
        }
    }

    public void minHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;
        
        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public T pop() {
        if (heap.size() == 0) {
            return null;
        }
        T root = heap.get(0);
        T lastItem = heap.remove(heap.size() - 1);
        if (heap.size() > 0) {
            heap.set(0, lastItem);
            minHeapify(0);
        }
        return root;
    }

    public void add(T item) {
        heap.add(item);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(parent(i)).compareTo(heap.get(i)) > 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}

// Examples
class MinHeapDemo {
    public static void main(String[] args) {
        MinHeap<Integer> intHeap = new MinHeap<>();
        intHeap.buildMinHeap(List.of(5, 4, 8, 10, 9, 7));

        System.out.println("Initial Min-Heap: " + intHeap);
        System.out.println("Removed element: " + intHeap.pop());
        System.out.println("Heap after removing root: " + intHeap);

        MinHeap<Float> floatHeap = new MinHeap<>();
        floatHeap.add(2.3f);
        floatHeap.add(1.2f);
        floatHeap.add(5.6f);
        floatHeap.add(3.4f);
        floatHeap.add(4.8f);
        floatHeap.add(6.7f);

        System.out.println("Initial Float Min-Heap: " + floatHeap);
        System.out.println("Removed element: " + floatHeap.pop());
        System.out.println("Heap after removing root: " + floatHeap);
    }
}
