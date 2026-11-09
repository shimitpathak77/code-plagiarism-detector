import java.util.Arrays;

// Merge two already sorted arrays into one sorted array
public class P15_MergeSortedArrays_light {

    public static int[] mergeArrays(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int l = 0, r = 0, m = 0;
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                merged[m++] = left[l++];
            } else {
                merged[m++] = right[r++];
            }
        }
        while (l < left.length) merged[m++] = left[l++];
        while (r < right.length) merged[m++] = right[r++];
        return merged;
    }

    public static void main(String[] args) {
        int[][][] cases = {
                {{1, 3, 5}, {2, 4, 6}},
                {{1, 2}, {0, 5, 9, 10}},
                {{}, {4, 7}},
                {{1, 1, 2}, {1, 3}}
        };
        for (int[][] c : cases) {
            System.out.println(Arrays.toString(c[0]) + " + " + Arrays.toString(c[1])
                    + " = " + Arrays.toString(mergeArrays(c[0], c[1])));
        }
    }
}
