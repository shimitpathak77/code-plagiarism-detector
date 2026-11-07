public class CoinChange {
    private static boolean usable(int coin, int amount, int[] dp) {
        return coin <= amount && dp[amount - coin] >= 0;
    }

    private static int smaller(int a, int b) {
        return a < b ? a : b;
    }

    public static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int steps = 0;
        dp[0] = 0;
        int target = 1;
        while (target <= amount) {
            dp[target] = -1;
            int c = 0;
            boolean any = false;
            while (c < coins.length) {
                steps++;
                if (usable(coins[c], target, dp)) {
                    int candidate = dp[target - coins[c]] + 1;
                    if (!any) {
                        dp[target] = candidate;
                        any = true;
                    } else {
                        dp[target] = smaller(dp[target], candidate);
                    }
                }
                c++;
            }
            target++;
        }
        return dp[amount];
    }
}