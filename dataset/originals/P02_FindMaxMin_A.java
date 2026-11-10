public class P02_FindMaxMin_A {

    // Returns {min, max} in a single pass
    public static int[] findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        int[] arr = {7, -3, 12, 0, 25, -8, 14};
        int[] result = findMinMax(arr);
        System.out.println("Minimum: " + result[0]);
        System.out.println("Maximum: " + result[1]);

        int[] same = {5, 5, 5};
        int[] r2 = findMinMax(same);
        System.out.println("All equal -> Min: " + r2[0] + ", Max: " + r2[1]);
    }
}
