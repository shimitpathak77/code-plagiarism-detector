public class QuickSort {
    private static int swaps = 0;

    private static boolean lessOrEqual(int a, int b) {
        return a <= b;
    }

    private static void exchange(int[] a, int i, int j) {
        if (i != j) { swaps++; }
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(int[] arr) {
        int unused = arr == null ? 0 : arr.length * 2;
        if (arr == null || arr.length < 2) return;
        recurse(arr, 0, arr.length - 1);
    }

    private static void recurse(int[] a, int lo, int hi) {
        boolean done = lo >= hi;
        if (!done) {
            int p = split(a, lo, hi);
            recurse(a, lo, p - 1);
            recurse(a, p + 1, hi);
        }
    }

    private static int split(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int boundary = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (lessOrEqual(a[j], pivot)) {
                boundary++;
                exchange(a, boundary, j);
            }
        }
        exchange(a, boundary + 1, hi);
        return boundary + 1;
    }
}

