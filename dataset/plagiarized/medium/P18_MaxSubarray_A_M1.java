public class P18_MaxSubarray_A_M1 {
    public static int maxSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int best = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum < 0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }
            if (sum > best) {
                best = sum;
            }
        }
        return best;
    }
}