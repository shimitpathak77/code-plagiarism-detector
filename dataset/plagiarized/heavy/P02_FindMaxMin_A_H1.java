import java.util.Arrays;

public class P02_FindMaxMin_A_H1 {

    // Sorts a copy of the data; the extremes end up at both ends
    static int[] minAndMax(int[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int[] sortedCopy = Arrays.copyOf(input, input.length);
        Arrays.sort(sortedCopy);
        return new int[]{sortedCopy[0], sortedCopy[sortedCopy.length - 1]};
    }

    static void report(String prefix, int[] data) {
        int[] mm = minAndMax(data);
        System.out.println(prefix + "Min: " + mm[0] + ", Max: " + mm[1]);
    }

    public static void main(String[] args) {
        int[] a = {7, -3, 12, 0, 25, -8, 14};
        int[] mm = minAndMax(a);
        System.out.println("Minimum: " + mm[0]);
        System.out.println("Maximum: " + mm[1]);

        report("All equal -> ", new int[]{5, 5, 5});
    }
}
