public class EditDistance {
    public static int editDistance(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        int j = 0;
        while (j <= n) {
            dp[0][j] = j;
            j++;
        }
        int i = 0;
        while (i <= m) {
            dp[i][0] = i;
            i++;
        }
        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                if (a.charAt(i - 1) != b.charAt(j - 1)) {
                    int best = dp[i - 1][j];
                    if (dp[i][j - 1] < best) {
                        best = dp[i][j - 1];
                    }
                    if (dp[i - 1][j - 1] < best) {
                        best = dp[i - 1][j - 1];
                    }
                    dp[i][j] = best + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}