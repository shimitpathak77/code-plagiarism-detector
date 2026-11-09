import java.util.*;

public class DFS {
    public static List<Integer> dfs(List<List<Integer>> graph, int start) {
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];
        explore(graph, start, visited, order);
        return order;
    }

    private static void explore(List<List<Integer>> graph, int node, boolean[] visited, List<Integer> order) {
        visited[node] = true;
        order.add(node);
        for (int next : graph.get(node)) {
            if (!visited[next]) explore(graph, next, visited, order);
        }
    }
}

