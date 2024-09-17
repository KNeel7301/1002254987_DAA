import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int uniqueIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[uniqueIndex]) {
                uniqueIndex++;
                array[uniqueIndex] = array[i];
            }
        }
        return uniqueIndex + 1;
    }
    public static void main(String[] args) {
        int[] array1 = {2, 2, 2, 2, 2};
        int newSize1 = removeDuplicates(array1);
        System.out.println("Array after removing duplicates: " + Arrays.toString(Arrays.copyOfRange(array1, 0, newSize1)));
        // Output: [2]
        int[] array2 = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int newSize2 = removeDuplicates(array2);
        System.out.println("Array after removing duplicates: " + Arrays.toString(Arrays.copyOfRange(array2, 0, newSize2)));
        // Output: [1, 2, 3, 4, 5]
    }
}
