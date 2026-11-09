public class P18_MaxSubarray {
    public static int maxSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int currentSum = arr[0];
        int bestSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            bestSum = Math.max(bestSum, currentSum);
        }
        return bestSum;
    }
}
