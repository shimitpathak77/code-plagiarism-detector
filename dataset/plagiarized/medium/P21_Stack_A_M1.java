public class P21_Stack_A_M1 {
    private final int[] stack;
    private int sp;

    public P21_Stack_A_M1(int capacity) {
        stack = new int[capacity];
        sp = 0;
    }

    public void push(int value) {
        if (sp == stack.length) {
            throw new IllegalStateException("Stack overflow");
        }
        stack[sp++] = value;
    }

    public int pop() {
        if (sp == 0) {
            throw new IllegalStateException("Stack underflow");
        }
        return stack[--sp];
    }

    public int peek() {
        if (sp == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[sp - 1];
    }

    public boolean isEmpty() {
        return sp == 0;
    }

    public boolean isFull() {
        return sp == stack.length;
    }

    public int size() {
        return sp;
    }
}
