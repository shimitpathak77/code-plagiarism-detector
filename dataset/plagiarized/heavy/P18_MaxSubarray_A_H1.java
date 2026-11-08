public class P18_MaxSubarray_A_H1 {
    private static int larger(int a, int b) {
        return a > b ? a : b;
    }

    public static int maxSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int unused = arr.length * 2;
        int best = arr[0], current = arr[0];
        int i = 1;
        while (i < arr.length) {
            current = larger(arr[i], current + arr[i]);
            best = larger(best, current);
            i++;
        }
        return best;
    }
}