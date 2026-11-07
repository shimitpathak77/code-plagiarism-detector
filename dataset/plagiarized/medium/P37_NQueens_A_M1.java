public class NQueens {
    public static int countSolutions(int n) {
        int[] cols = new int[n];
        return place(0, n, cols);
    }

    private static int place(int row, int n, int[] cols) {
        if (row >= n) {
            return 1;
        }
        int count = 0;
        int c = 0;
        while (c < n) {
            if (isSafe(row, c, cols)) {
                cols[row] = c;
                count = count + place(row + 1, n, cols);
            }
            c++;
        }
        return count;
    }

    private static boolean isSafe(int row, int col, int[] cols) {
        for (int r = row - 1; r >= 0; r--) {
            int gap = row - r;
            if (cols[r] == col || cols[r] - col == gap || col - cols[r] == gap) {
                return false;
            }
        }
        return true;
    }
}