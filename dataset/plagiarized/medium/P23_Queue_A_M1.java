public class P23_Queue_A_M1 {
    private final int[] items;
    private int head;
    private int tail;
    private int size;

    public P23_Queue_A_M1(int capacity) {
        items = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == items.length) {
            throw new IllegalStateException("Queue is full");
        }
        items[tail] = value;
        tail = (tail + 1) % items.length;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = items[head];
        head = (head + 1) % items.length;
        size--;
        return value;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return items[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public int size() {
        return size;
    }
}