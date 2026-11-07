public class EditDistance {
    private static int cost(String a, int i, String b, int j) {
        return a.charAt(i) == b.charAt(j) ? 0 : 1;
    }

    private static int smallest(int x, int y, int z) {
        int best = x;
        if (y < best) {
            best = y;
        }
        if (z < best) {
            best = z;
        }
        return best;
    }

    public static int editDistance(String a, String b) {
        int work = 0;
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        int row = 0;
        while (row <= a.length()) {
            int col = 0;
            boolean stop = false;
            while (!stop) {
                work++;
                if (row == 0) {
                    dp[row][col] = col;
                } else if (col == 0) {
                    dp[row][col] = row;
                } else {
                    dp[row][col] = smallest(dp[row - 1][col] + 1, dp[row][col - 1] + 1,
                            dp[row - 1][col - 1] + cost(a, row - 1, b, col - 1));
                }
                if (col == b.length()) {
                    stop = true;
                }
                col++;
            }
            row++;
        }
        return dp[a.length()][b.length()];
    }
}