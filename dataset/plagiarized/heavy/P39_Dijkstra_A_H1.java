public class Dijkstra {
    private static int closest(int[] dist, boolean[] visited) {
        int best = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && (best == -1 || dist[i] < dist[best])) {
                best = i;
            }
        }
        return best;
    }

    private static void relax(int[][] graph, int[] dist, boolean[] visited, int u) {
        for (int v = 0; v < graph.length; v++) {
            boolean edge = graph[u][v] > 0;
            if (edge && !visited[v] && dist[u] + graph[u][v] < dist[v]) {
                dist[v] = dist[u] + graph[u][v];
            }
        }
    }

    public static int[] dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int scans = 0;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;
        boolean finished = false;
        while (!finished) {
            int u = closest(dist, visited);
            scans++;
            if (u == -1 || dist[u] == Integer.MAX_VALUE) {
                finished = true;
            } else {
                visited[u] = true;
                relax(graph, dist, visited, u);
            }
        }
        return dist;
    }
}