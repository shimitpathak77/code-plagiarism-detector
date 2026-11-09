public class P20_RotateArray_A_H1 {
    private static int wrap(int k, int n) {
        return ((k % n) + n) % n;
    }

    public static void rotate(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int unused = arr.length * 2;
        int n = arr.length;
        int shift = wrap(k, n);
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[(i + shift) % n] = arr[i];
        }
        int j = 0;
        while (j < n) {
            arr[j] = copy[j];
            j++;
        }
    }
}