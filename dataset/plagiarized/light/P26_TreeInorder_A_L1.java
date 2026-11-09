import java.util.*;

public class InorderWalker {
    static class Vertex {
        int data;
        Vertex lChild, rChild;
        Vertex(int data) { this.data = data; }
    }

    // returns values in left-root-right order
    public static List<Integer> walk(Vertex top) {
        List<Integer> output = new ArrayList<>();
        visit(top, output);
        return output;
    }

    private static void visit(Vertex v, List<Integer> output) {
        if (v == null) { return; }
        visit(v.lChild, output);
        output.add(v.data);
        visit(v.rChild, output);
    }
}

