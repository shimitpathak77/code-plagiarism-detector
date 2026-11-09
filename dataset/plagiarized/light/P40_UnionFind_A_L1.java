public class DisjointSet {
    private int[] leader;
    private int[] height;

    public DisjointSet(int size) {
        leader = new int[size];
        height = new int[size];
        for (int k = 0; k < size; k++) {
            leader[k] = k;
        }
    }

    public int root(int x) {
        if (leader[x] != x) {
            leader[x] = root(leader[x]);
        }
        return leader[x];
    }

    public void merge(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) {
            return;
        }
        if (height[rootP] < height[rootQ]) {
            leader[rootP] = rootQ;
        } else if (height[rootP] > height[rootQ]) {
            leader[rootQ] = rootP;
        } else {
            leader[rootQ] = rootP;
            height[rootP]++;
        }
    }

    public boolean sameGroup(int p, int q) {
        return root(p) == root(q);
    }
}