public class P15_MergeSortedArrays_B {
    public static int[] mergeSortedArrays(int[] a, int[] b) {
        if (a == null) return b == null ? new int[0] : b.clone();
        if (b == null) return a.clone();
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            result[k++] = (a[i] <= b[j]) ? a[i++] : b[j++];
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
    }
}
