public class Knapsack {
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        int i = 1;
        while (i <= n) {
            int w = 0;
            while (w <= capacity) {
                if (weights[i - 1] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    int take = values[i - 1] + dp[i - 1][w - weights[i - 1]];
                    int skip = dp[i - 1][w];
                    dp[i][w] = take > skip ? take : skip;
                }
                w++;
            }
            i++;
        }
        return dp[n][capacity];
    }
}