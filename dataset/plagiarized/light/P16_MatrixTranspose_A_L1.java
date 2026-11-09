import java.util.Arrays;

// Transpose of an m x n matrix
public class P16_MatrixTranspose_light {

    public static int[][] transposeMatrix(int[][] mat) {
        if (mat.length == 0) return new int[0][0];
        int numRows = mat.length;
        int numCols = mat[0].length;
        int[][] out = new int[numCols][numRows];
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                out[c][r] = mat[r][c];
            }
        }
        return out;
    }

    private static void show(String title, int[][] mat) {
        System.out.println(title);
        for (int[] line : mat) {
            System.out.println("  " + Arrays.toString(line));
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        show("Original (2x3):", a);
        show("Transpose (3x2):", transposeMatrix(a));

        int[][] b = {{1, 2}, {3, 4}};
        show("Original (2x2):", b);
        show("Transpose (2x2):", transposeMatrix(b));
    }
}
