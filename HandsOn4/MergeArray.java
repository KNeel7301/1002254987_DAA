import java.util.PriorityQueue;
import java.util.Arrays;

class MergeArray {

    static class Node implements Comparable<Node> {
        int value;
        int arrayIndex;  
        int elementIndex; 

        public Node(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }

        @Override
        public int compareTo(Node other) {
            return this.value - other.value;
        }
    }

    public static int[] mergeKSortedArrays(int[][] arrays, int K, int N) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        int totalElements = K * N;
        int[] result = new int[totalElements];
        
        for (int i = 0; i < K; i++) {
            if (arrays[i].length > 0) {
                minHeap.add(new Node(arrays[i][0], i, 0));
            }
        }
        int index = 0; 
        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            result[index++] = current.value;

            if (current.elementIndex + 1 < N) {
                minHeap.add(new Node(arrays[current.arrayIndex][current.elementIndex + 1], current.arrayIndex, current.elementIndex + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] arrays1 = {
            {1, 3, 5, 7},
            {2, 4, 6, 8},
            {0, 9, 10, 11}
        };
        int[] mergedArray1 = mergeKSortedArrays(arrays1, 3, 4);
        System.out.println("Merged Array 1: " + Arrays.toString(mergedArray1));

        int[][] arrays2 = {
            {1, 3, 7},
            {2, 4, 8},
            {9, 10, 11}
        };
        int[] mergedArray2 = mergeKSortedArrays(arrays2, 3, 3);
        System.out.println("Merged Array 2: " + Arrays.toString(mergedArray2));
    }
}
