public class LongestCommonSubsequence {
    public static int lcs(String a, String b) {
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        int[][] dp = new int[y.length + 1][x.length + 1];
        int j = 1;
        while (j <= y.length) {
            int i = 1;
            while (i <= x.length) {
                if (x[i - 1] != y[j - 1]) {
                    dp[j][i] = dp[j][i - 1] > dp[j - 1][i] ? dp[j][i - 1] : dp[j - 1][i];
                } else {
                    dp[j][i] = 1 + dp[j - 1][i - 1];
                }
                i++;
            }
            j++;
        }
        return dp[y.length][x.length];
    }
}