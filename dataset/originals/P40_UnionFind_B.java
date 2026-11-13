public class P40_UnionFind_B {
    private final int[] id;
    public P40_UnionFind_B(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) id[i] = i;
    }
    public int find(int x) { return id[x]; }
    public void union(int a, int b) {
        int rootA = id[a];
        int rootB = id[b];
        if (rootA == rootB) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == rootA) id[i] = rootB;
        }
    }
    public boolean connected(int a, int b) { return id[a] == id[b]; }
}
