/* Find the smallest and largest value in an array */
public class P02_FindMaxMin_A_L1 {

    // returns { smallest, largest } using one traversal
    public static int[] findMinMax(int[] arr)
    {
        if (arr == null || arr.length == 0)
        {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int lo = arr[0];
        int hi = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] < lo) lo = arr[i];
            if (arr[i] > hi) hi = arr[i];
        }
        return new int[]{lo, hi};
    }

    public static void main(String[] args)
    {
        int[] arr = {7, -3, 12, 0, 25, -8, 14};
        int[] result = findMinMax(arr);
        System.out.println("Minimum: " + result[0]);
        System.out.println("Maximum: " + result[1]);

        int[] same = {5, 5, 5};
        int[] r2 = findMinMax(same);
        System.out.println("All equal -> Min: " + r2[0] + ", Max: " + r2[1]);
    }
}
