public class TreeHeight {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        return (l > r ? l : r) + 1;
    }
}

