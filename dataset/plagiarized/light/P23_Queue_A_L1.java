public class P23_Queue_A_L1 {
    // circular queue stored in a fixed-size array
    private final int[] items;
    private int first;
    private int last;
    private int total;

    public P23_Queue_A_L1(int limit) {
        items = new int[limit];
        first = 0;
        last = -1;
        total = 0;
    }

    public void add(int value) {
        if (full()) {
            throw new IllegalStateException("Queue is full");
        }
        last = (last + 1) % items.length;
        items[last] = value;
        total++;
    }

    public int poll() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = items[first];
        first = (first + 1) % items.length;
        total--;
        return value;
    }

    public int front() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items[first];
    }

    public boolean empty() {
        return total == 0;
    }

    public boolean full() {
        return total == items.length;
    }

    public int count() {
        return total;
    }
}