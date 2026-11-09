import java.util.*;

public class DFS {
    private static int pops = 0;

    private static void pushReversed(Deque<Integer> stack, List<Integer> neighbors) {
        for (int i = neighbors.size() - 1; i >= 0; i--) {
            stack.push(neighbors.get(i));
        }
    }

    public static List<Integer> dfs(List<List<Integer>> graph, int start) {
        int unused = 0;
        List<Integer> order = new ArrayList<>();
        boolean[] done = new boolean[graph.size()];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        boolean running = true;
        while (running) {
            if (stack.isEmpty()) {
                running = false;
            } else {
                int node = stack.pop();
                pops++;
                if (!done[node]) {
                    done[node] = true;
                    order.add(node);
                    pushReversed(stack, graph.get(node));
                }
            }
        }
        return order;
    }
}

