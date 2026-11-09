public class P07_BinarySearch_A {

    // Iterative binary search on a sorted array; returns index or -1
    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;   // avoids overflow
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sorted = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int[] keys = {23, 2, 91, 7};
        for (int key : keys) {
            int idx = binarySearch(sorted, key);
            System.out.println(key + (idx >= 0 ? " found at index " + idx : " not found"));
        }
    }
}
