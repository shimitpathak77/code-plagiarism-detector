import java.util.Arrays;

public class P16_MatrixTranspose_medium {

    // column-major walk using while loops
    public static int[][] transpose(int[][] m) {
        int r = m.length;
        if (r == 0) return new int[0][0];
        int c = m[0].length;
        int[][] t = new int[c][r];
        int col = 0;
        while (col < c) {
            int row = 0;
            while (row < r) {
                t[col][row] = m[row][col];
                row++;
            }
            col++;
        }
        return t;
    }

    private static void print(String label, int[][] m) {
        System.out.println(label);
        for (int[] row : m) {
            System.out.println("  " + Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}};
        print("Original (2x3):", m);
        print("Transpose (3x2):", transpose(m));

        int[][] sq = {{1, 2}, {3, 4}};
        print("Original (2x2):", sq);
        print("Transpose (2x2):", transpose(sq));
    }
}
