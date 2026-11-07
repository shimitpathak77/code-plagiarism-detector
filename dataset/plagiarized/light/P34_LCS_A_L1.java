public class CommonSubseq {
    // length of the longest shared subsequence
    public static int longest(String s, String t) {
        int rows = s.length();
        int cols = t.length();
        int[][] table = new int[rows + 1][cols + 1];
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                if (s.charAt(r - 1) == t.charAt(c - 1)) {
                    table[r][c] = table[r - 1][c - 1] + 1;
                } else {
                    table[r][c] = Math.max(table[r - 1][c], table[r][c - 1]);
                }
            }
        }
        return table[rows][cols];
    }
}