public class P32_MergeSort_B {
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int n = arr.length;
        int[] temp = new int[n];
        for (int width = 1; width < n; width *= 2) {
            for (int i = 0; i < n; i += 2 * width) {
                int mid = Math.min(i + width, n);
                int right = Math.min(i + 2 * width, n);
                merge(arr, temp, i, mid, right);
            }
        }
    }
    private static void merge(int[] arr, int temp[], int left, int mid, int right) {
        int i = left, j = mid, k = left;
        while (i < mid && j < right) {
            temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }
        while (i < mid) temp[k++] = arr[i++];
        while (j < right) temp[k++] = arr[j++];
        for (i = left; i < right; i++) arr[i] = temp[i];
    }
}
