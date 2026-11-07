public class MergeSorter {
    // entry point
    public static void sort(int[] data) {
        if (data.length < 2) { return; }
        divide(data, 0, data.length - 1);
    }

    private static void divide(int[] data, int start, int end) {
        if (start >= end) { return; }
        int center = start + (end - start) / 2;
        divide(data, start, center);
        divide(data, center + 1, end);
        combine(data, start, center, end);
    }

    private static void combine(int[] data, int start, int center, int end) {
        int[] buffer = new int[end - start + 1];
        int a = start, b = center + 1, c = 0;
        while (a <= center && b <= end) {
            if (data[a] <= data[b]) { buffer[c++] = data[a++]; }
            else { buffer[c++] = data[b++]; }
        }
        while (a <= center) { buffer[c++] = data[a++]; }
        while (b <= end) { buffer[c++] = data[b++]; }
        for (int x = 0; x < buffer.length; x++) { data[start + x] = buffer[x]; }
    }
}
