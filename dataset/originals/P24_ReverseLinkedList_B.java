public class P24_ReverseLinkedList_B {
    public static class Node {
        public int val;
        public Node next;
        public Node(int val) { this.val = val; }
    }
    public static Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
