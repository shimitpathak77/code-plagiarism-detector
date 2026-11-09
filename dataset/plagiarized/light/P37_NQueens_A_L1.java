public class QueensCounter {
    // how many ways can size queens be placed safely
    public static int solve(int size) {
        int[] position = new int[size];
        return put(0, size, position);
    }

    private static int put(int line, int size, int[] position) {
        if (line == size) {
            return 1;
        }
        int total = 0;
        for (int k = 0; k < size; k++) {
            if (allowed(line, k, position)) {
                position[line] = k;
                total += put(line + 1, size, position);
            }
        }
        return total;
    }

    private static boolean allowed(int line, int spot, int[] position) {
        for (int p = 0; p < line; p++) {
            if (position[p] == spot || Math.abs(position[p] - spot) == line - p) {
                return false;
            }
        }
        return true;
    }
}