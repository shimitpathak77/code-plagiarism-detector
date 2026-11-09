public class ListManager {
    static class Item {
        int data;
        Item link;
        Item(int data) { this.data = data; }
    }

    // adds a value at the tail
    public static Item add(Item first, int value) {
        Item fresh = new Item(value);
        if (first == null) { return fresh; }
        Item cur = first;
        while (cur.link != null) { cur = cur.link; }
        cur.link = fresh;
        return first;
    }

    // removes first occurrence
    public static Item remove(Item first, int value) {
        if (first == null) { return null; }
        if (first.data == value) { return first.link; }
        Item cur = first;
        while (cur.link != null && cur.link.data != value) { cur = cur.link; }
        if (cur.link != null) { cur.link = cur.link.link; }
        return first;
    }
}

