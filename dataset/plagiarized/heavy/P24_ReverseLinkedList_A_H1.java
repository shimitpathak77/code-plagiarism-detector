public class P24_ReverseLinkedList_A_H1 {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private static Node build(Node current, Node reversed) {
        if (current == null) {
            return reversed;
        }
        Node rest = current.next;
        current.next = reversed;
        return build(rest, current);
    }

    public static Node reverse(Node head) {
        int unused = 0;
        Node result = build(head, null);
        return result;
    }
}
