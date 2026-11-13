import java.util.*;

public class P29_DFS_B {
    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> result = new ArrayList<>();
        if (graph == null || !graph.containsKey(start)) return result;
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (visited.add(curr)) {
                result.add(curr);
                List<Integer> neighbors = graph.getOrDefault(curr, Collections.emptyList());
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int next = neighbors.get(i);
                    if (!visited.contains(next)) stack.push(next);
                }
            }
        }
        return result;
    }
}
