public class CoinChange {
    public static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int limit = amount + 1;
        java.util.Arrays.fill(dp, limit);
        dp[0] = 0;
        int k = 0;
        while (k < coins.length) {
            for (int i = coins[k]; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coins[k]] + 1);
            }
            k++;
        }
        return dp[amount] >= limit ? -1 : dp[amount];
    }
}