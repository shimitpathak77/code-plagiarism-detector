public class ItemPacker {
    // best total value that fits in the bag
    public static int pack(int[] wt, int[] val, int limit) {
        int count = wt.length;
        int[][] table = new int[count + 1][limit + 1];
        for (int item = 1; item <= count; item++) {
            for (int cap = 0; cap <= limit; cap++) {
                if (wt[item - 1] <= cap) {
                    table[item][cap] = Math.max(table[item - 1][cap], val[item - 1] + table[item - 1][cap - wt[item - 1]]);
                } else {
                    table[item][cap] = table[item - 1][cap];
                }
            }
        }
        return table[count][limit];
    }
}