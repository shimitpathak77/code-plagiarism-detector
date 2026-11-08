public class P21_Stack {
    private final int[] data;
    private int top;

    public P21_Stack(int capacity) {
        data = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("Stack overflow");
        }
        data[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        return data[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public int size() {
        return top + 1;
    }
}
