import java.util.Scanner;
import java.util.Random;

class selection_matrix {

    public static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array sizes to test
        int[] testSizes = {10, 100, 1000, 5000, 10000};
        
        // Loop through different sizes
        for (int size : testSizes) {
            // Generate a random array
            int arr[] = new int[size];
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(10000); // Random integers between 0 and 9999
            }

            System.out.println("\nTesting with " + size + " elements:");

            // Measure time before sorting
            long startTime = System.currentTimeMillis();

            selectionSort(arr, size);

            // Measure time after sorting
            long endTime = System.currentTimeMillis();

            System.out.println("Time taken to sort: " + (endTime - startTime) + " milliseconds");

            // Uncomment the next two lines if you want to print the sorted array
            // System.out.println("\nArray after sorting: ");
            // printArray(arr, size);
        }

        sc.close();
    }
}
