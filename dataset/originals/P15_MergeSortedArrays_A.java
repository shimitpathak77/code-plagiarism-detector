import java.util.Arrays;

/** P15 Merge Two Sorted Arrays - O(m + n) time, O(m + n) space */
public class P15_MergeSortedArrays_A {

    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
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