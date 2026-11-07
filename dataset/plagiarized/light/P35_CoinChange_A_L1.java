public class CoinChanger {
    // fewest coins that add up to the target, or -1
    public static int fewest(int[] denominations, int target) {
        int[] table = new int[target + 1];
        for (int s = 1; s <= target; s++) {
            table[s] = Integer.MAX_VALUE;
        }
        table[0] = 0;
        for (int s = 1; s <= target; s++) {
            for (int d : denominations) {
                if (d <= s && table[s - d] != Integer.MAX_VALUE) {
                    table[s] = Math.min(table[s], table[s - d] + 1);
                }
            }
        }
        return table[target] == Integer.MAX_VALUE ? -1 : table[target];
    }
}