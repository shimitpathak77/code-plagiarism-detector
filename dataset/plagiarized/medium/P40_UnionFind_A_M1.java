public class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        int i = 0;
        while (i < n) {
            parent[i] = i;
            i++;
        }
    }

    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (rank[rootA] == rank[rootB]) {
                parent[rootB] = rootA;
                rank[rootA]++;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootA] = rootB;
            }
        }
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }
}