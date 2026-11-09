public class SubsetSum {
    public static boolean subsetSum(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int s = 1; s <= target; s++) {
                if (nums[i - 1] <= s) {
                    dp[i][s] = dp[i - 1][s] || dp[i - 1][s - nums[i - 1]];
                } else {
                    dp[i][s] = dp[i - 1][s];
                }
            }
        }
        return dp[nums.length][target];
    }
}