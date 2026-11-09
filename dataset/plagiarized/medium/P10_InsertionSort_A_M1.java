import java.util.Arrays;

public class P10_InsertionSort_medium {

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // moves each element left by adjacent swaps until it is in place
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j - 1, j);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {12, 11, 13, 5, 6};
        System.out.println("Before: " + Arrays.toString(a));
        insertionSort(a);
        System.out.println("After : " + Arrays.toString(a));

        int[] sorted = {1, 2, 3, 4};
        insertionSort(sorted);
        System.out.println("Sorted: " + Arrays.toString(sorted));

        int[] dup = {3, 3, 1, 2, 2};
        insertionSort(dup);
        System.out.println("Dups  : " + Arrays.toString(dup));
    }
}
