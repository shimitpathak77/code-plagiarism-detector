import java.util.EmptyStackException;

public class P21_Stack_B {
    private static class Node {
        int data;
        Node next;
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node top;
    private int count;

    public void push(int value) {
        top = new Node(value, top);
        count++;
    }
    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        int val = top.data;
        top = top.next;
        count--;
        return val;
    }
    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }
    public boolean isEmpty() { return top == null; }
    public boolean isFull() { return false; }
    public int size() { return count; }
}
