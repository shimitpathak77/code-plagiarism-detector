public class NQueens {
    private static int found;

    public static int countSolutions(int n) {
        found = 0;
        boolean[] usedCol = new boolean[n];
        boolean[] usedDiag = new boolean[2 * n];
        boolean[] usedAnti = new boolean[2 * n];
        int unused = n * n;
        search(0, n, usedCol, usedDiag, usedAnti);
        return found;
    }

    private static void search(int row, int n, boolean[] usedCol, boolean[] usedDiag, boolean[] usedAnti) {
        if (row == n) {
            found++;
            return;
        }
        int c = 0;
        while (c < n) {
            int d = row + c;
            int a = row - c + n;
            if (!usedCol[c] && !usedDiag[d] && !usedAnti[a]) {
                mark(usedCol, usedDiag, usedAnti, c, d, a, true);
                search(row + 1, n, usedCol, usedDiag, usedAnti);
                mark(usedCol, usedDiag, usedAnti, c, d, a, false);
            }
            c++;
        }
    }

    private static void mark(boolean[] usedCol, boolean[] usedDiag, boolean[] usedAnti,
                             int c, int d, int a, boolean value) {
        usedCol[c] = value;
        usedDiag[d] = value;
        usedAnti[a] = value;
    }
}