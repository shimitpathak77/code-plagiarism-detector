import java.util.*;

public class DepthFirst {
    // goes as deep as possible first
    public static List<Integer> traverse(List<List<Integer>> adj, int source) {
        List<Integer> result = new ArrayList<>();
        boolean[] seen = new boolean[adj.size()];
        go(adj, source, seen, result);
        return result;
    }

    private static void go(List<List<Integer>> adj, int current, boolean[] seen, List<Integer> result) {
        seen[current] = true;
        result.add(current);
        for (int neighbor : adj.get(current)) {
            if (!seen[neighbor]) { go(adj, neighbor, seen, result); }
        }
    }
}

