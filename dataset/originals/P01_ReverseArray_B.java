public class P01_ReverseArray_B {
    public static void reverse(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        reverseHelper(arr, 0, arr.length - 1);
    }
    private static void reverseHelper(int[] arr, int start, int end) {
        if (start >= end) return;
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseHelper(arr, start + 1, end - 1);
    }
}
