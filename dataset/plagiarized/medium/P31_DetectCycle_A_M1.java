public class DetectCycle {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    public static boolean hasCycle(Node head) {
        if (head == null) return false;
        Node slow = head;
        Node fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

