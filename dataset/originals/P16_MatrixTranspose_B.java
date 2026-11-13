public class P16_MatrixTranspose_B {
    public static int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] trans = new int[cols][rows];
        int total = rows * cols;
        for (int idx = 0; idx < total; idx++) {
            int r = idx / cols;
            int c = idx % cols;
            trans[c][r] = matrix[r][c];
        }
        return trans;
    }
}
