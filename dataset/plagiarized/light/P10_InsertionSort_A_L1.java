import java.util.Arrays;

// Insertion sort: grow a sorted prefix one element at a time
public class P10_InsertionSort_light {

    public static void sortByInsertion(int[] values) {
        for (int idx = 1; idx < values.length; idx++) {
            int current = values[idx];
            int pos = idx - 1;
            while (pos >= 0 && values[pos] > current) {
                values[pos + 1] = values[pos];
                pos--;
            }
            values[pos + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] first = {12, 11, 13, 5, 6};
        System.out.println("Before: " + Arrays.toString(first));
        sortByInsertion(first);
        System.out.println("After : " + Arrays.toString(first));

        int[] already = {1, 2, 3, 4};
        sortByInsertion(already);
        System.out.println("Sorted: " + Arrays.toString(already));

        int[] repeated = {3, 3, 1, 2, 2};
        sortByInsertion(repeated);
        System.out.println("Dups  : " + Arrays.toString(repeated));
    }
}
