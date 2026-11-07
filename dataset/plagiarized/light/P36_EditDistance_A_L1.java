public class StringTransformer {
    // number of edits needed to turn s into t
    public static int distance(String s, String t) {
        int rows = s.length();
        int cols = t.length();
        int[][] grid = new int[rows + 1][cols + 1];
        for (int r = 0; r <= rows; r++) {
            grid[r][0] = r;
        }
        for (int c = 0; c <= cols; c++) {
            grid[0][c] = c;
        }
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                if (s.charAt(r - 1) == t.charAt(c - 1)) {
                    grid[r][c] = grid[r - 1][c - 1];
                } else {
                    grid[r][c] = 1 + Math.min(grid[r - 1][c - 1], Math.min(grid[r - 1][c], grid[r][c - 1]));
                }
            }
        }
        return grid[rows][cols];
    }
}