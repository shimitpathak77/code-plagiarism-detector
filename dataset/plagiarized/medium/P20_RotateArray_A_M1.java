public class P20_RotateArray_A_M1 {
    private static void reverseRange(int[] a, int i, int j) {
        for (; i < j; i++, j--) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    public static void rotate(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        k %= n;
        if (k < 0) {
            k += n;
        }
        reverseRange(arr, 0, n - k - 1);
        reverseRange(arr, n - k, n - 1);
        reverseRange(arr, 0, n - 1);
    }
}