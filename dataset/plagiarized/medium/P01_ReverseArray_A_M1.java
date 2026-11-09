import java.util.Arrays;

public class P01_ReverseArray_A_M1 {

    static void show(String label, int[] values) {
        System.out.println(label + Arrays.toString(values));
    }

    // swaps mirrored positions up to the middle of the array
    static void flip(int[] data) {
        int size = data.length;
        for (int k = 0; k < size / 2; k++) {
            int mirror = size - 1 - k;
            int hold = data[mirror];
            data[mirror] = data[k];
            data[k] = hold;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        show("Original: ", numbers);
        flip(numbers);
        show("Reversed: ", numbers);

        int[] one = {42};
        flip(one);
        show("Single  : ", one);

        int[] none = {};
        flip(none);
        show("Empty   : ", none);
    }
}
