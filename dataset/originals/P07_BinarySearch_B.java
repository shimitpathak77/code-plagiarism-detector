public class P07_BinarySearch_B {
    public static int binarySearch(int[] arr, int key) {
        if (arr == null) return -1;
        return search(arr, key, 0, arr.length - 1);
    }
    private static int search(int[] arr, int key, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) >>> 1;
        if (arr[mid] == key) return mid;
        if (arr[mid] > key) return search(arr, key, low, mid - 1);
        return search(arr, key, mid + 1, high);
    }
}
