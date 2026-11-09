public class Knapsack {
    private static int larger(int x, int y) {
        return x >= y ? x : y;
    }

    private static boolean fits(int weight, int room) {
        return weight <= room;
    }

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int visited = 0;
        int[][] dp = new int[n + 1][capacity + 1];
        int item = 0;
        while (item < n) {
            item++;
            int room = 0;
            boolean last = false;
            while (!last) {
                visited++;
                if (fits(weights[item - 1], room)) {
                    int withItem = values[item - 1] + dp[item - 1][room - weights[item - 1]];
                    dp[item][room] = larger(dp[item - 1][room], withItem);
                } else {
                    dp[item][room] = dp[item - 1][room];
                }
                if (room == capacity) {
                    last = true;
                }
                room++;
            }
        }
        return dp[n][capacity];
    }
}