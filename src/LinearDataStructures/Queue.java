package LinearDataStructures;

public class Queue<T> {
    
    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getData() {
            return this.data;
        }

        public Node<T> getNext() {
            return this.next;
        }
    }

    private Node<T> head;
    private int size;

    public Queue() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return this.size;
    }

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node<T> current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
        this.size++;
    }

    public T poll() {
        if (this.head == null) {
            return null;
        }
        T data = this.head.getData();
        this.head = this.head.getNext();
        this.size--;
        return data;
    }

    public T peek() {
        if (this.head == null) {
            return null;
        }
        return this.head.getData();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = this.head;
        while (current != null) {
            sb.append(current.getData().toString());
            sb.append(", ");
            current = current.getNext();
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
