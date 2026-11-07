public class TreeHeight {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private static int calls = 0;

    private static int larger(int a, int b) {
        return a > b ? a : b;
    }

    public static int height(TreeNode root) {
        int unused = 0;
        calls++;
        boolean empty = root == null;
        int result = 0;
        if (!empty) {
            int l = height(root.left);
            int r = height(root.right);
            result = 1 + larger(l, r);
        }
        return result;
    }
}

