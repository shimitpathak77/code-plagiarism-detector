import java.util.*;

public class BFS {
    public static List<Integer> bfs(List<List<Integer>> graph, int start) {
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        while (queue.size() > 0) {
            int node = queue.pollFirst();
            order.add(node);
            List<Integer> neighbors = graph.get(node);
            for (int i = 0; i < neighbors.size(); i++) {
                int next = neighbors.get(i);
                if (visited[next]) continue;
                visited[next] = true;
                queue.offer(next);
            }
        }
        return order;
    }
}

