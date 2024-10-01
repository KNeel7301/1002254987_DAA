import java.util.Arrays;

public class QuickSortNonRandomChoicePivot {

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }
    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
    static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSortNonRandomChoicePivot ob = new QuickSortNonRandomChoicePivot();

        int[] additionalArray = {20, 11, 13, 5, 1, 8};
        System.out.println("Additional Array Case:");
        ob.quickSort(additionalArray, 0, additionalArray.length - 1);
        printArray(additionalArray);

        int[] bestCaseArray = {11, 22, 33, 44, 55, 66, 77, 88, 99, 100};
        System.out.println("Best Case Scenario:");
        ob.quickSort(bestCaseArray, 0, bestCaseArray.length - 1);
        printArray(bestCaseArray);

        int[] worstCaseArray = {100, 99, 88, 77, 66, 55, 44, 33, 22, 11};
        System.out.println("Worst Case Scenario:");
        ob.quickSort(worstCaseArray, 0, worstCaseArray.length - 1);
        printArray(worstCaseArray);

        int[] averageCaseArray = {23, 11, 34, 1, 15, 9, 21, 6, 5, 34, 5};
        System.out.println("Average Case Scenario:");
        ob.quickSort(averageCaseArray, 0, averageCaseArray.length - 1);
        printArray(averageCaseArray);
    }
}
