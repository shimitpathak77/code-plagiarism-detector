import java.util.Arrays;

/* Program: reverse the elements of an array */
public class P01_ReverseArray_A_L1 {

    /**
     * Reverse the given array in-place.
     */
    public static void reverse(int[] arr)
    {
        int i = 0;
        int j = arr.length - 1;
        while (i < j)
        {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Original: " + Arrays.toString(arr));
        reverse(arr);
        System.out.println("Reversed: " + Arrays.toString(arr));

        int[] single = {42};
        reverse(single);
        System.out.println("Single  : " + Arrays.toString(single));

        int[] empty = {};
        reverse(empty);
        System.out.println("Empty   : " + Arrays.toString(empty));
    }
}
