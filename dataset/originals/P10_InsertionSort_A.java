import java.util.Arrays;

/** P09 Selection Sort - O(n^2) time, O(1) space */
public class P09_SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int n = arr.length;
        if (n < 2) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {64, 25, 12, 22, 11};
        System.out.println("Before: " + Arrays.toString(a));
        selectionSort(a);
        System.out.println("After : " + Arrays.toString(a));

        int[] empty = {};
        selectionSort(empty);
        System.out.println("Empty : " + Arrays.toString(empty));

        int[] dup = {3, 1, 3, 2, 1};
        selectionSort(dup);
        System.out.println("Dups  : " + Arrays.toString(dup));
    }
}