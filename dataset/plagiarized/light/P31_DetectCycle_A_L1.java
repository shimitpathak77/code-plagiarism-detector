public class CycleChecker {
    static class Item {
        int data;
        Item link;
        Item(int data) { this.data = data; }
    }

    // checks for a loop using two pointers
    public static boolean containsLoop(Item first) {
        Item tortoise = first, hare = first;
        while (hare != null && hare.link != null) {
            tortoise = tortoise.link;
            hare = hare.link.link;
            if (tortoise == hare) { return true; }
        }
        return false;
    }
}

