public class P20_RotateArray_A_L1 {
    // moves every element to the right by the given number of steps
    public static void rotateRight(int[] data, int steps) {
        if (data == null || data.length == 0) {
            return;
        }
        int len = data.length;
        steps = steps % len;
        if (steps < 0) {
            steps += len;
        }
        flip(data, 0, len - 1);
        flip(data, 0, steps - 1);
        flip(data, steps, len - 1);
    }

    private static void flip(int[] data, int from, int to) {
        while (from < to) {
            int temp = data[from];
            data[from] = data[to];
            data[to] = temp;
            from++;
            to--;
        }
    }
}