public class P07_BinarySearch_A_H1 {

    // Recursive halving of the search interval
    private static int search(int[] a, int key, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return search(a, key, lo, mid - 1);
        } else if (key > a[mid]) {
            return search(a, key, mid + 1, hi);
        }
        return mid;
    }

    static int find(int[] a, int key) {
        return search(a, key, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] sortedData = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        for (int k : new int[]{23, 2, 91, 7}) {
            int i = find(sortedData, k);
            System.out.println(k + (i >= 0 ? " found at index " + i : " not found"));
        }
    }
}
