import java.util.NoSuchElementException;

public class P23_Queue_B {
    private static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }
    private Node head;
    private Node tail;
    private int size;

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public int dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        int value = head.val;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return value;
    }
    public int peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return head.val;
    }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return false; }
    public int size() { return size; }
}
