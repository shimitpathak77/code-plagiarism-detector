import java.util.Arrays;

/** P16 Matrix Transpose - works for any m x n matrix, O(m * n) */
public class P16_MatrixTranspose_A_L1 {

    public static int[][] transpose(int[][] matrix) {
        if (matrix.length == 0) return new int[0][0];
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
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