public class UnionFind {
    private int[] parent;
    private int[] size;
    private int components;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        components = n;
        int i = 0;
        while (i < n) {
            parent[i] = i;
            size[i] = 1;
            i++;
        }
    }

    private int climb(int x) {
        int current = x;
        while (parent[current] != current) {
            current = parent[current];
        }
        int walker = x;
        while (parent[walker] != current) {
            int next = parent[walker];
            parent[walker] = current;
            walker = next;
        }
        return current;
    }

    private void link(int big, int small) {
        parent[small] = big;
        size[big] += size[small];
        components--;
    }

    public int find(int x) {
        return climb(x);
    }

    public void union(int a, int b) {
        int ra = climb(a);
        int rb = climb(b);
        boolean same = ra == rb;
        if (!same) {
            if (size[ra] >= size[rb]) {
                link(ra, rb);
            } else {
                link(rb, ra);
            }
        }
    }

    public boolean connected(int a, int b) {
        return climb(a) == climb(b);
    }
}