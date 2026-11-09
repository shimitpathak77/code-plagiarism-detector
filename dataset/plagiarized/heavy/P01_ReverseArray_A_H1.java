import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P01_ReverseArray_A_H1 {

    // Uses a stack (LIFO) to invert the order of the elements
    static void invert(int[] items) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int value : items) {
            stack.push(value);
        }
        int pos = 0;
        while (!stack.isEmpty()) {
            items[pos++] = stack.pop();
        }
    }

    static String describe(int[] items) {
        return Arrays.toString(items);
    }

    public static void main(String[] args) {
        int[][] cases = {{1, 2, 3, 4, 5, 6}, {42}, {}};
        String[] labels = {"Original: ", "Single  : ", "Empty   : "};

        System.out.println(labels[0] + describe(cases[0]));
        invert(cases[0]);
        System.out.println("Reversed: " + describe(cases[0]));

        invert(cases[1]);
        System.out.println(labels[1] + describe(cases[1]));

        invert(cases[2]);
        System.out.println(labels[2] + describe(cases[2]));
    }
}
