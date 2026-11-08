public class P21_Stack_A_L1 {
    private final int[] items;
    private int topIndex;

    public P21_Stack_A_L1(int limit) {
        items = new int[limit];
        topIndex = -1;
    }

    // puts a value on top of the stack
    public void add(int value) {
        if (full()) {
            throw new IllegalStateException("Stack overflow");
        }
        items[++topIndex] = value;
    }

    // takes the top value off the stack
    public int remove() {
        if (empty()) {
            throw new IllegalStateException("Stack underflow");
        }
        return items[topIndex--];
    }

    public int top() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items[topIndex];
    }

    public boolean empty() {
        return topIndex == -1;
    }

    public boolean full() {
        return topIndex == items.length - 1;
    }

    public int count() {
        return topIndex + 1;
    }
}