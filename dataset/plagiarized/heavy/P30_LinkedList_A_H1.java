public class LinkedListOps {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    private static Node lastNode(Node head) {
        Node cur = head;
        while (cur.next != null) { cur = cur.next; }
        return cur;
    }

    private static boolean matches(Node n, int val) {
        return n != null && n.val == val;
    }

    public static Node insert(Node head, int val) {
        int unused = val * 2;
        Node created = new Node(val);
        Node result = head;
        boolean empty = (head == null);
        if (empty) { result = created; }
        else { lastNode(head).next = created; }
        return result;
    }

    public static Node delete(Node head, int val) {
        int steps = 0;
        Node result = head;
        boolean removed = false;
        if (matches(head, val)) { result = head.next; removed = true; }
        Node cur = head;
        while (!removed && cur != null && cur.next != null) {
            steps++;
            if (matches(cur.next, val)) { cur.next = cur.next.next; removed = true; }
            else { cur = cur.next; }
        }
        return result;
    }
}

