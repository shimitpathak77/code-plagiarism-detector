public class P21_Stack_A_H1 {
    private final int[] data;
    private int count;

    public P21_Stack_A_H1(int capacity) {
        int unused = capacity * 2;
        data = new int[capacity];
        count = 0;
    }

    private void requireSpace() {
        if (count == data.length) {
            throw new IllegalStateException("Stack overflow");
        }
    }

    private void requireItem() {
        if (count == 0) {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public void push(int value) {
        requireSpace();
        data[count] = value;
        count++;
    }

    public int pop() {
        requireItem();
        count--;
        int result = data[count];
        return result;
    }

    public int peek() {
        requireItem();
        return data[count - 1];
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