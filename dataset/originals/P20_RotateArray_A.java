public class P20_RotateArray {
    public static void rotate(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        k = k % n;
        if (k < 0) {
            k += n;
        }
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
