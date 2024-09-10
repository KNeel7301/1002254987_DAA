public class BubbleSortTest {

    public static void main(String[] args) {
        // Test with different sizes of arrays
        int[] sizes = {10, 100, 1000, 5000, 10000}; // Sizes of arrays to test

        for (int size : sizes) {
            // Generate an array with random elements
            int[] arr = generateRandomArray(size);

            // Print the size of the array being tested
            System.out.println("Testing array of size: " + size);

            // Measure the time taken to sort the array
            long startTime = System.nanoTime();
            Bubble.bubbleSort(arr, size);
            long endTime = System.nanoTime();

            // Print the time taken to sort
            long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
            System.out.println("Time taken to sort: " + duration + " ms");

            // Uncomment the following line if you want to print the sorted array as well
            // Bubble.printArray(arr, size);
        }
    }

    // Method to generate an array with random integers
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 10000); // Random integer between 0 and 9999
        }
        return arr;
    }
}
