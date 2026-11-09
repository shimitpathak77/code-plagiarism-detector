import java.util.Arrays;

public class MergeSort {
    public static void sort(int[] arr) {
        if (arr.length > 1) split(arr, 0, arr.length - 1);
    }

    private static void split(int[] a, int lo, int hi) {
        if (lo < hi) {
            int m = (lo + hi) >>> 1;
            split(a, lo, m);
            split(a, m + 1, hi);
            combine(a, lo, m, hi);
        }
    }

    private static void combine(int[] a, int lo, int m, int hi) {
        int[] left = Arrays.copyOfRange(a, lo, m + 1);
        int[] right = Arrays.copyOfRange(a, m + 1, hi + 1);
        int i = 0, j = 0, k = lo;
        while (i < left.length && j < right.length) {
            a[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        }
        while (i < left.length) a[k++] = left[i++];
        while (j < right.length) a[k++] = right[j++];
    }
}
