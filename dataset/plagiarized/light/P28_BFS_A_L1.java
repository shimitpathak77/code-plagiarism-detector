import java.util.*;

public class BreadthFirst {
    // level by level traversal
    public static List<Integer> traverse(List<List<Integer>> adj, int source) {
        List<Integer> result = new ArrayList<>();
        boolean[] seen = new boolean[adj.size()];
        Queue<Integer> line = new LinkedList<>();
        seen[source] = true;
        line.add(source);
        while (!line.isEmpty()) {
            int current = line.poll();
            result.add(current);
            for (int neighbor : adj.get(current)) {
                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    line.add(neighbor);
                }
            }
        }
        return result;
    }
}
