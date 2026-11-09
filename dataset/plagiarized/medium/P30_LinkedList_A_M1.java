public class LinkedListOps {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    public static Node insert(Node head, int val) {
        if (head == null) return new Node(val);
        head.next = insert(head.next, val);
        return head;
    }

    public static Node delete(Node head, int val) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.val == val) {
                prev.next = cur.next;
                break;
            }
            prev = cur;
        }
        return dummy.next;
    }
}

