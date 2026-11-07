import java.util.*;

public class BFS {
    private static int levels = 0;

    private static boolean enqueueIfNew(Queue<Integer> q, boolean[] seen, int n) {
        if (seen[n]) { return false; }
        seen[n] = true;
        q.add(n);
        return true;
    }

    public static List<Integer> bfs(List<List<Integer>> graph, int start) {
        int unused = graph.size() * 2;
        List<Integer> order = new ArrayList<>();
        boolean[] seen = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        boolean started = enqueueIfNew(q, seen, start);
        while (started && !q.isEmpty()) {
            int node = q.remove();
            levels++;
            order.add(node);
            for (int idx = 0; idx < graph.get(node).size(); idx++) {
                enqueueIfNew(q, seen, graph.get(node).get(idx));
            }
        }
        return order;
    }
}

