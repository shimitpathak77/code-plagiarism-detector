public class LongestCommonSubsequence {
    private static boolean same(String s, int i, String t, int j) {
        return s.charAt(i) == t.charAt(j);
    }

    private static int maxOf(int p, int q) {
        if (p > q) {
            return p;
        }
        return q;
    }

    public static int lcs(String a, String b) {
        int cells = 0;
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        int i = 0;
        while (i < a.length()) {
            int j = 0;
            boolean stop = b.length() == 0;
            while (!stop) {
                cells++;
                if (same(a, i, b, j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = maxOf(dp[i][j + 1], dp[i + 1][j]);
                }
                j++;
                if (j >= b.length()) {
                    stop = true;
                }
            }
            i++;
        }
        return dp[a.length()][b.length()];
    }
}