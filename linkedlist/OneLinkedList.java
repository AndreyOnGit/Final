package ru.ae.linkedlist;

public class OneLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void add(String val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
            size++;
            return;
        }

        Node newNode = new Node(val);
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    public void add(int index, String val) {
        if (index < 0) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s cannot be more than real size %s", index, size));
        }

        if (index > size) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s cannot be more than real size %s", index, size));
        }

        if (index == 0) {
            if (head == null) {
                head = new Node(val);
                tail = head;
            } else {
                Node next = head;
                head = new Node(val);
                head.setNext(next);
                size++;
            }
            return;
        }

        if (index == size) {
            add(val);
            return;
        }

        int currentIndex = 1;
        Node current = head.getNext();
        Node previous = head;

        while (currentIndex != index) {
            previous = current;
            current = current.getNext();
            currentIndex++;
        }

        if (current == null) {
            add(val);
        } else {
            size++;
            Node addedNode = new Node(val);
            previous.setNext(addedNode);
            addedNode.setNext(current);
        }
    }

    public void remove(int index) {
        if (index < 0) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s cannot be more than real size %s", index, size));
        }

        if (index >= size) {
            throw new IndexExceedsSizeLengthException(String.format("Index %s cannot be more than real size %s", index, size));
        }

        if (index == 0) {
            if (head == null) return;
            else {
                head = head.getNext();
                size--;
                return;
            }
        }

        int currentIndex = 1;
        Node current = head.getNext();
        Node previous = head;

        while (currentIndex != index) {
            previous = current;
            current = current.getNext();
            currentIndex++;
        }
        previous.setNext(current.getNext());

        if (currentIndex == (size - 1)) {
            tail = previous;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public Iterator iterator() {
        return new Iterator(head);
    }

    private static class Node {
        private String value;
        private Node next;

        public Node(String value) {
            this(value, null);
        }

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OneDirectionalList{" +
                "head=" + head +
                '}';
    }

    public static class Iterator {
        private Node head;
        private Node current;

        private Iterator() {
        }

        private Iterator(Node current) {
            this.head = current;
        }

        public boolean hasNext() {
            if (current == null) {
                return head != null;
            }
            return current.getNext() != null;
        }

        public String next() {
            if (current == null) {
                current = head;
            } else {
                current = current.getNext();
            }
            return current.getValue();
        }
    }
}
