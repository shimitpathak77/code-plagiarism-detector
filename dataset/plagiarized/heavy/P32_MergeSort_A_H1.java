public class MergeSort {
    private static int comparisons = 0;

    private static int midpoint(int l, int r) {
        return l + (r - l) / 2;
    }

    private static boolean isLeq(int a, int b) {
        comparisons++;
        return a <= b;
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int unused = arr.length * 3;
        divide(arr, 0, arr.length - 1);
    }

    private static void divide(int[] a, int l, int r) {
        boolean base = l >= r;
        if (!base) {
            int m = midpoint(l, r);
            divide(a, l, m);
            divide(a, m + 1, r);
            conquer(a, l, m, r);
        }
    }

    private static void conquer(int[] a, int l, int m, int r) {
        int[] buf = new int[a.length];
        for (int t = l; t <= r; t++) { buf[t] = a[t]; }
        int p = l, q = m + 1, w = l;
        while (w <= r) {
            if (p > m) { a[w++] = buf[q++]; }
            else if (q > r) { a[w++] = buf[p++]; }
            else if (isLeq(buf[p], buf[q])) { a[w++] = buf[p++]; }
            else { a[w++] = buf[q++]; }
        }
    }
}

