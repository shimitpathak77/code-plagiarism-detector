import java.util.*;

public class P35_CoinChange_B {
    public static int minCoins(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0 || coins == null || coins.length == 0) return -1;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[amount + 1];
        queue.offer(amount);
        visited[amount] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int coin : coins) {
                    int next = curr - coin;
                    if (next == 0) return level;
                    if (next > 0 && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}
