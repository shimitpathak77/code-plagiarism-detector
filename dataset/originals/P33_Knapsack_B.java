public class P33_Knapsack_B {
    public static int knapsack(int[] weights, int[] values, int capacity) {
        if (weights == null || values == null || capacity <= 0) return 0;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            int wt = weights[i];
            int val = values[i];
            for (int w = capacity; w >= wt; w--) {
                dp[w] = Math.max(dp[w], dp[w - wt] + val);
            }
        }
        return dp[capacity];
    }
}
