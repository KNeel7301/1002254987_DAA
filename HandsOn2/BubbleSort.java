import java.util.Scanner;

class Bubble {
    public static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    public static void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int flag = 1;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = 0;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (flag == 1) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in an array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("\nEnter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nUnsorted array: ");
        printArray(arr, n);

        bubbleSort(arr, n);

        System.out.println("Sorted array: ");
        printArray(arr, n);

        sc.close();
    }
}
