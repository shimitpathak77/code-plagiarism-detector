import java.util.Arrays;
import java.util.stream.IntStream;

public class P16_MatrixTranspose_heavy {

    // stream pipeline: each new row is the matching column of the input
    public static int[][] transpose(int[][] matrix) {
        if (matrix.length == 0) return new int[0][0];
        return IntStream.range(0, matrix[0].length)
                .mapToObj(col -> Arrays.stream(matrix).mapToInt(row -> row[col]).toArray())
                .toArray(int[][]::new);
    }

    private static void print(String label, int[][] m) {
        System.out.println(label);
        Arrays.stream(m).forEach(row -> System.out.println("  " + Arrays.toString(row)));
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
