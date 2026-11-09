import java.util.Arrays;

public class P09_SelectionSort_heavy {

    // recursive: park the maximum of the prefix at its end, then shrink the prefix
    public static void selectionSort(int[] arr) {
        placeMaxAtEnd(arr, arr.length);
    }

    private static void placeMaxAtEnd(int[] a, int size) {
        if (size <= 1) return;
        int maxIdx = 0;
        for (int k = 1; k < size; k++) {
            if (a[k] > a[maxIdx]) maxIdx = k;
        }
        int tmp = a[size - 1];
        a[size - 1] = a[maxIdx];
        a[maxIdx] = tmp;
        placeMaxAtEnd(a, size - 1);
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
