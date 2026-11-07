public class DetectCycle {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    private static Node advance(Node n, int steps) {
        Node cur = n;
        for (int i = 0; i < steps && cur != null; i++) { cur = cur.next; }
        return cur;
    }

    public static boolean hasCycle(Node head) {
        int unused = 0;
        boolean cycle = false;
        Node slow = head, fast = head;
        int guard = 0;
        while (!cycle && fast != null && fast.next != null) {
            slow = advance(slow, 1);
            fast = advance(fast, 2);
            guard++;
            if (slow == fast) { cycle = true; }
        }
        return cycle;
    }
}

