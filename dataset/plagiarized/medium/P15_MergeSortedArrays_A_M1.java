import java.util.Arrays;

public class P15_MergeSortedArrays_medium {

    // single loop over output positions, pick from whichever side is smaller
    public static int[] mergeSortedArrays(int[] x, int[] y) {
        int[] out = new int[x.length + y.length];
        int p = 0, q = 0;
        for (int k = 0; k < out.length; k++) {
            if (q >= y.length || (p < x.length && x[p] <= y[q])) {
                out[k] = x[p++];
            } else {
                out[k] = y[q++];
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[][][] tests = {
                {{1, 3, 5}, {2, 4, 6}},
                {{1, 2}, {0, 5, 9, 10}},
                {{}, {4, 7}},
                {{1, 1, 2}, {1, 3}}
        };
        for (int[][] t : tests) {
            System.out.println(Arrays.toString(t[0]) + " + " + Arrays.toString(t[1])
                    + " = " + Arrays.toString(mergeSortedArrays(t[0], t[1])));
        }
    }
}
