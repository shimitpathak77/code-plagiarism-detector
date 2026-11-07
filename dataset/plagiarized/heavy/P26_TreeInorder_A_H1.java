import java.util.*;

public class TreeInorder {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private static int visited = 0;

    private static boolean isEmpty(TreeNode n) {
        return n == null;
    }

    private static void record(List<Integer> list, int v) {
        visited++;
        list.add(v);
    }

    public static List<Integer> inorder(TreeNode root) {
        int unused = 42;
        List<Integer> result = new ArrayList<>();
        boolean skip = isEmpty(root);
        if (!skip) {
            descend(root, result);
        }
        return result;
    }

    private static void descend(TreeNode node, List<Integer> out) {
        if (!isEmpty(node.left)) { descend(node.left, out); }
        record(out, node.val);
        if (!isEmpty(node.right)) { descend(node.right, out); }
    }
}

