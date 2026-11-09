public class P24_ReverseLinkedList_A_M1 {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node reverse(Node head) {
        Node prev = null;
        for (Node cur = head; cur != null; ) {
            Node nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }
}
