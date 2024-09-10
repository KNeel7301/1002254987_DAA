import java.util.Arrays;

public class MergeSort {
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = ((left + right) / 2);
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int size1 = mid - left + 1;
        int size2 = right - mid;

        int[] LeftArray = new int[size1];
        int[] RightArray = new int[size2];

        System.arraycopy(arr, left, LeftArray, 0, size1);

        for (int j = 0; j < size2; ++j) {
            RightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < size1 && j < size2) {
            if (LeftArray[i] < RightArray[j]) {
                arr[k] = LeftArray[i++];
            } else {

                arr[k] = RightArray[j++];
            }
            k++;
        }

        while (i < size1) {
            arr[k++] = LeftArray[i++];
        }
        while (j < size2) {
            arr[k++] = RightArray[j++];
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 5, 2, 4, 7, 1, 3, 2, 6 };
        System.out.println("Before sorting: " + Arrays.toString(numbers));
        mergeSort(numbers, 0, numbers.length - 1);
        System.out.println("After sorting: " + Arrays.toString(numbers));
    }
}