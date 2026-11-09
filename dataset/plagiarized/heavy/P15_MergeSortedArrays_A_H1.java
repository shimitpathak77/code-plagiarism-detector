import java.util.Arrays;

public class P15_MergeSortedArrays_heavy {

    // recursive merge; when one side runs out, bulk-copy the rest of the other
    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        mergeFrom(a, 0, b, 0, result, 0);
        return result;
    }

    private static void mergeFrom(int[] a, int i, int[] b, int j, int[] out, int k) {
        if (i == a.length) {
            System.arraycopy(b, j, out, k, b.length - j);
            return;
        }
        if (j == b.length) {
            System.arraycopy(a, i, out, k, a.length - i);
            return;
        }
        if (a[i] <= b[j]) {
            out[k] = a[i];
            mergeFrom(a, i + 1, b, j, out, k + 1);
        } else {
            out[k] = b[j];
            mergeFrom(a, i, b, j + 1, out, k + 1);
        }
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
