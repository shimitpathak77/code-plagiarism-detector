public class SumChecker {
    // can some of the numbers add up exactly to goal
    public static boolean canReach(int[] values, int goal) {
        boolean[][] table = new boolean[values.length + 1][goal + 1];
        for (int r = 0; r <= values.length; r++) {
            table[r][0] = true;
        }
        for (int r = 1; r <= values.length; r++) {
            for (int s = 1; s <= goal; s++) {
                if (values[r - 1] <= s) {
                    table[r][s] = table[r - 1][s] || table[r - 1][s - values[r - 1]];
                } else {
                    table[r][s] = table[r - 1][s];
                }
            }
        }
        return table[values.length][goal];
    }
}