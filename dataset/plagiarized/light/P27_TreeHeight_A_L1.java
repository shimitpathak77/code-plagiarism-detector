public class TreeDepth {
    static class Vertex {
        int data;
        Vertex lChild, rChild;
        Vertex(int data) { this.data = data; }
    }

    // number of levels in the tree
    public static int depth(Vertex top) {
        if (top == null) { return 0; }
        return 1 + Math.max(depth(top.lChild), depth(top.rChild));
    }
}

