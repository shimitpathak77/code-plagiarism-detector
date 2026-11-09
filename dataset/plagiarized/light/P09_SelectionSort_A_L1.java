import java.util.Arrays;

// Sorts an integer array in ascending order using selection sort
public class P09_SelectionSort_light {

    public static void sortBySelection(int[] data) {
        int len = data.length;
        for (int outer = 0; outer < len - 1; outer++) {
            int smallest = outer;
            for (int inner = outer + 1; inner < len; inner++) {
                if (data[inner] < data[smallest]) {
                    smallest = inner;
                }
            }
            if (smallest != outer) {
                int temp = data[outer];
                data[outer] = data[smallest];
                data[smallest] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] x = {64, 25, 12, 22, 11};
        System.out.println("Before: " + Arrays.toString(x));
        sortBySelection(x);
        System.out.println("After : " + Arrays.toString(x));

        int[] none = {};
        sortBySelection(none);
        System.out.println("Empty : " + Arrays.toString(none));

        int[] repeated = {3, 1, 3, 2, 1};
        sortBySelection(repeated);
        System.out.println("Dups  : " + Arrays.toString(repeated));
    }
}
