public class LinkedListOps {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    public static Node insert(Node head, int val) {
        Node node = new Node(val);
        if (head == null) return node;
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = node;
        return head;
    }

    public static Node delete(Node head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        Node curr = head;
        while (curr.next != null && curr.next.val != val) curr = curr.next;
        if (curr.next != null) curr.next = curr.next.next;
        return head;
    }
}

