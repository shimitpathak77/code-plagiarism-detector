public class NQueens {
    public static int countSolutions(int n) {
        int[] cols = new int[n];
        return place(0, n, cols);
    }

    private static int place(int row, int n, int[] cols) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int c = 0; c < n; c++) {
            if (isSafe(row, c, cols)) {
                cols[row] = c;
                count += place(row + 1, n, cols);
            }
        }
        return count;
    }

    private static boolean isSafe(int row, int col, int[] cols) {
        for (int r = 0; r < row; r++) {
            if (cols[r] == col || Math.abs(cols[r] - col) == row - r) {
                return false;
            }
        }
        return true;
    }
}