public class SubsetSum {
    public static boolean subsetSum(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        int i = 0;
        while (i <= nums.length) {
            dp[i][0] = true;
            i++;
        }
        for (int s = 1; s <= target; s++) {
            for (int k = 1; k <= nums.length; k++) {
                if (nums[k - 1] > s) {
                    dp[k][s] = dp[k - 1][s];
                } else {
                    dp[k][s] = dp[k - 1][s - nums[k - 1]] || dp[k - 1][s];
                }
            }
        }
        return dp[nums.length][target];
    }
}