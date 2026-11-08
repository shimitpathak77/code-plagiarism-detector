public class P24_ReverseLinkedList_A_L1 {
    public static class ListNode {
        int value;
        ListNode link;

        ListNode(int value) {
            this.value = value;
        }
    }

    // turns the list around and returns the new first node
    public static ListNode reverseList(ListNode first) {
        ListNode before = null;
        ListNode current = first;
        while (current != null) {
            ListNode after = current.link;
            current.link = before;
            before = current;
            current = after;
        }
        return before;
    }
}