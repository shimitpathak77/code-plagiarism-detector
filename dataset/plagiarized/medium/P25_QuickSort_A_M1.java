public class QuickSort {
    public static void sort(int[] arr) {
        if (arr != null && arr.length > 1) quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(a, lo, hi);
        quickSort(a, lo, p - 1);
        quickSort(a, p + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int store = lo;
        int j = lo;
        while (j < hi) {
            if (a[j] < pivot) {
                int t = a[store];
                a[store] = a[j];
                a[j] = t;
                store++;
            }
            j++;
        }
        int t = a[store];
        a[store] = a[hi];
        a[hi] = t;
        return store;
    }
}

