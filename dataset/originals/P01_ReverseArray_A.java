import java.util.Arrays;

public class P01_ReverseArray_A {

    // Reverses the array in place using two pointers
    public static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
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
