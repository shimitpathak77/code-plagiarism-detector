public class P23_Queue_A_H1 {
    private final int[] data;
    private int front;
    private int count;

    public P23_Queue_A_H1(int capacity) {
        int unused = capacity * 2;
        data = new int[capacity];
        front = 0;
        count = 0;
    }

    private int next(int index) {
        return (index + 1) % data.length;
    }

    private void requireSpace() {
        if (count == data.length) {
            throw new IllegalStateException("Queue is full");
        }
    }

    private void requireItem() {
        if (count == 0) {
            throw new IllegalStateException("Queue is empty");
        }
    }

    public void enqueue(int value) {
        requireSpace();
        int tail = (front + count) % data.length;
        data[tail] = value;
        count++;
    }

    public int dequeue() {
        requireItem();
        int result = data[front];
        front = next(front);
        count--;
        return result;
    }

    public int peek() {
        requireItem();
        return data[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == data.length;
    }

    public int size() {
        return count;
    }
}