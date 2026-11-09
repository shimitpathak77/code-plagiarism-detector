public class QuickSorter {
    // sorts the array in place
    public static void sort(int[] data) {
        run(data, 0, data.length - 1);
    }

    private static void run(int[] data, int start, int end) {
        if (start < end) {
            int pos = divide(data, start, end);
            run(data, start, pos - 1);
            run(data, pos + 1, end);
        }
    }

    private static int divide(int[] data, int start, int end) {
        int key = data[end];
        int k = start - 1;
        for (int m = start; m < end; m++) {
            if (data[m] <= key) {
                k++;
                exchange(data, k, m);
            }
        }
        exchange(data, k + 1, end);
        return k + 1;
    }

    private static void exchange(int[] data, int x, int y) {
        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }
}

