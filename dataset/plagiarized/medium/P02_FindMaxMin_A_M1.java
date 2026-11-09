public class P02_FindMaxMin_A_M1 {

    static int[] extremes(int[] values) {
        if (values == null || values.length < 1) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int smallest = values[0];
        int largest = values[0];
        for (int current : values) {
            smallest = Math.min(smallest, current);
            largest = Math.max(largest, current);
        }
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        int[] first = {7, -3, 12, 0, 25, -8, 14};
        int[] out1 = extremes(first);
        System.out.println("Minimum: " + out1[0]);
        System.out.println("Maximum: " + out1[1]);

        int[] second = {5, 5, 5};
        int[] out2 = extremes(second);
        System.out.println("All equal -> Min: " + out2[0] + ", Max: " + out2[1]);
    }
}
