import java.util.Arrays;

public class P08_BubbleSort_A_H1 {

    // One recursive level = one "bubbling" pass that floats the largest value to index n-1
    private static void sinkPass(int[] data, int n) {
        if (n <= 1) {
            return;
        }
        boolean moved = false;
        for (int i = 0; i + 1 < n; i++) {
            if (data[i] > data[i + 1]) {
                data[i] ^= data[i + 1];
                data[i + 1] ^= data[i];
                data[i] ^= data[i + 1];
                moved = true;
            }
        }
        if (moved) {
            sinkPass(data, n - 1);
        }
    }

    static void sort(int[] data) {
        sinkPass(data, data.length);
    }

    public static void main(String[] args) {
        int[] input = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before: " + Arrays.toString(input));
        sort(input);
        System.out.println("After : " + Arrays.toString(input));
    }
}
