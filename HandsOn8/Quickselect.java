import java.util.Random;
import java.util.Scanner;

public class Quickselect {

    public static int quickSelect(int[] arr, int left, int right, int i) {
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = partition(arr, left, right);

        if (i == pivotIndex) {
            return arr[pivotIndex];
        }
        else if (i < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, i);
        }
        else {
            return quickSelect(arr, pivotIndex + 1, right, i);
        }
    }
    private static int partition(int[] arr, int left, int right) {
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);

        int storeIndex = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivotValue) {
                swap(arr, storeIndex, j);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);

        return storeIndex;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = {22, 1, 2, 6, 9, 29, 42};
        int n = arr.length;

        System.out.print("Enter the value of i: ");
        int i = scanner.nextInt();

        if (i < 1 || i > n) {
            System.out.println("Enter the valid value of i. It should be between 1 and " + n);
        } else {
            int ithSmallest = quickSelect(arr, 0, arr.length - 1, i - 1);
            System.out.println("The " + i + "th smallest element is " + ithSmallest);
        }

        scanner.close();
    }
}
