import java.util.Arrays;

public class P10_InsertionSort_heavy {

    // recursive; insertion point found by binary search, block shifted with arraycopy
    public static void insertionSort(int[] arr) {
        sortPrefix(arr, arr.length);
    }

    private static void sortPrefix(int[] a, int n) {
        if (n <= 1) return;
        sortPrefix(a, n - 1);
        int last = a[n - 1];
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] <= last) lo = mid + 1;
            else hi = mid;
        }
        System.arraycopy(a, lo, a, lo + 1, n - 1 - lo);
        a[lo] = last;
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
