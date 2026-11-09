public class ShortestPaths {
    // shortest distance from start to every node (MAX_VALUE if unreachable)
    public static int[] shortest(int[][] weights, int start) {
        int count = weights.length;
        int[] best = new int[count];
        boolean[] done = new boolean[count];
        for (int k = 0; k < count; k++) {
            best[k] = Integer.MAX_VALUE;
        }
        best[start] = 0;
        for (int round = 0; round < count; round++) {
            int current = -1;
            for (int k = 0; k < count; k++) {
                if (!done[k] && (current == -1 || best[k] < best[current])) {
                    current = k;
                }
            }
            if (best[current] == Integer.MAX_VALUE) {
                break;
            }
            done[current] = true;
            for (int next = 0; next < count; next++) {
                if (weights[current][next] > 0 && !done[next] && best[current] + weights[current][next] < best[next]) {
                    best[next] = best[current] + weights[current][next];
                }
            }
        }
        return best;
    }
}