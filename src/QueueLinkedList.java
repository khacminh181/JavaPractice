import linkedlist.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueLinkedList<Item> implements Iterable<Item>{
    private Node<Item> head;
    private Node<Item> tail;
    private int n;

    public QueueLinkedList() {
        this.head = null;
        this.tail = null;
        this.n = 0;
    }

    public boolean empty() {
        return head == null;
    }

    public void enqueue(Item item) {
        Node<Item> newNode = new Node<>(item, null);
        if (this.empty()) {
            this.head = this.tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        n++;
    }

    public Item dequeue() {
        if (this.empty()) {
            throw new NoSuchElementException("Queue Empty");
        }
        Item value = head.item;
        head = head.next;
        n--;
        if (this.empty()) {
            tail = null;
        }
        return value;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null ;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        QueueLinkedList<Integer> q = new QueueLinkedList<>();
        System.out.println(q.empty());
        q.enqueue(5);
        q.enqueue(5);
        q.enqueue(5);
        q.enqueue(5);
        q.dequeue();

        Iterator i = q.iterator();
        while (i.hasNext()) {
            Object element = i.next();
            System.out.print(element + " ");
        }

    }
}
