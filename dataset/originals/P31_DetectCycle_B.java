import java.util.HashSet;
import java.util.Set;

public class P31_DetectCycle_B {
    public static class Node {
        public int val;
        public Node next;
        public Node(int val) { this.val = val; }
    }
    public static boolean hasCycle(Node head) {
        Set<Node> seen = new HashSet<>();
        Node curr = head;
        while (curr != null) {
            if (!seen.add(curr)) return true;
            curr = curr.next;
        }
        return false;
    }
}
