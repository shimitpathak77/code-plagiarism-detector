public class SubsetSum {
    private static boolean canTake(int value, int sum) {
        return value <= sum;
    }

    public static boolean subsetSum(int[] nums, int target) {
        int work = 0;
        boolean[] reach = new boolean[target + 1];
        reach[0] = true;
        int idx = 0;
        while (idx < nums.length) {
            int value = nums[idx];
            int sum = target;
            while (sum >= 0) {
                work++;
                if (canTake(value, sum) && reach[sum - value]) {
                    reach[sum] = true;
                }
                sum--;
            }
            idx++;
        }
        return reach[target];
    }
}