public class Dijkstra {
    public static int[] dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        java.util.Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        dist[source] = 0;
        int round = 0;
        while (round < n) {
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                if (u == -1 || dist[i] < dist[u]) {
                    u = i;
                }
            }
            if (dist[u] == Integer.MAX_VALUE) {
                break;
            }
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 0 || visited[v]) {
                    continue;
                }
                int alt = dist[u] + graph[u][v];
                if (alt < dist[v]) {
                    dist[v] = alt;
                }
            }
            round++;
        }
        return dist;
    }
}