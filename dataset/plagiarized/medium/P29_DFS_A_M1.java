import java.util.*;

public class DFS {
    public static List<Integer> dfs(List<List<Integer>> graph, int start) {
        List<Integer> order = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        visit(graph, start, seen, order);
        return order;
    }

    private static void visit(List<List<Integer>> graph, int node, Set<Integer> seen, List<Integer> order) {
        seen.add(node);
        order.add(node);
        List<Integer> neighbors = graph.get(node);
        for (int i = 0; i < neighbors.size(); i++) {
            int n = neighbors.get(i);
            if (!seen.contains(n)) visit(graph, n, seen, order);
        }
    }
}

