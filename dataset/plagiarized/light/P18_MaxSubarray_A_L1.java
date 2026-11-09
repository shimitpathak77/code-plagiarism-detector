public class P18_MaxSubarray_A_L1 {
    // finds the biggest sum of a continuous part of the array
    public static int largestSum(int[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int running = data[0];
        int highest = data[0];
        for (int idx = 1; idx < data.length; idx++) {
            running = Math.max(data[idx], running + data[idx]);
            highest = Math.max(highest, running);
        }
        return highest;
    }
}