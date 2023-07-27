package LinearDataStructures;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    
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

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public LinkedList(LinkedList<T> other) {
        this.head = null;
        this.size = 0;
        for (T data : other) {
            this.add(data);
        }
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

    public void removeIf(T data) {
        if (this.head == null) {
            return;
        }

        if (this.head.getData().equals(data)) {
            this.head = this.head.getNext();
            this.size--;
            return;
        }

        Node<T> current = this.head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                this.size--;
                return;
            }
            current = current.getNext();
        }
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Node<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    // * toString() method
    @Override
    public String toString() {
        if (this.head == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = this.head;
        while (current.getNext() != null) {
            sb.append(current.getData());
            sb.append(", ");
            current = current.getNext();
        }
        sb.append(current.getData());
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public T next() {
                T data = this.current.getData();
                this.current = this.current.getNext();
                return data;
            }
        };
    }
}
