import java.util.Arrays;

public class P08_BubbleSort_A_M1 {

    private static void exchange(int[] v, int x, int y) {
        int carry = v[x];
        v[x] = v[y];
        v[y] = carry;
    }

    static void sortAscending(int[] values) {
        boolean changed = true;
        int limit = values.length - 1;
        while (changed && limit > 0) {
            changed = false;
            for (int p = 0; p < limit; p++) {
                if (values[p] > values[p + 1]) {
                    exchange(values, p, p + 1);
                    changed = true;
                }
            }
            limit--;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before: " + Arrays.toString(numbers));
        sortAscending(numbers);
        System.out.println("After : " + Arrays.toString(numbers));
    }
}
