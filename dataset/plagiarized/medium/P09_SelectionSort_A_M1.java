import java.util.Arrays;

public class P09_SelectionSort_medium {

    private static int indexOfMin(int[] a, int from) {
        int best = from;
        int j = from + 1;
        while (j < a.length) {
            if (a[j] < a[best]) {
                best = j;
            }
            j++;
        }
        return best;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void selectionSort(int[] arr) {
        int i = 0;
        while (i < arr.length - 1) {
            swap(arr, i, indexOfMin(arr, i));
            i++;
        }
    }

    public static void main(String[] args) {
        int[] a = {64, 25, 12, 22, 11};
        System.out.println("Before: " + Arrays.toString(a));
        selectionSort(a);
        System.out.println("After : " + Arrays.toString(a));

        int[] empty = {};
        selectionSort(empty);
        System.out.println("Empty : " + Arrays.toString(empty));

        int[] dup = {3, 1, 3, 2, 1};
        selectionSort(dup);
        System.out.println("Dups  : " + Arrays.toString(dup));
    }
}
