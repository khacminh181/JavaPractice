package queue_array;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class QueueArray<Item> implements Iterable<Item> {
    private final int kQueueCapacity = 5;
    private final int kQueuePositions = kQueueCapacity + 1;
    private Item[] q;
    private int insert;
    private int pop;

    public QueueArray() {
        this.q = (Item[]) new Object[kQueuePositions];
        this.insert = 0; // last
        this.pop = 0; // first
    }

    public void enqueue(Item value) {
        if (this.full()) {
            throw new Error("Queue full");
        }
        q[insert] = value;
        insert++;
    }

    public Item dequeue() {
        if (this.empty()) {
            throw new NoSuchElementException("Queue Empty");
        }

        Item value = q[pop];
        q[pop] = null;
        return value;
    }

    public boolean empty() {
        return this.insert == this.pop;
    }

    public boolean full() {
        return pop == (insert + 1) % kQueuePositions;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        @Override
        public boolean hasNext() {
            return i < kQueueCapacity;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = q[(i + pop) % q.length];
            i++;
            return item;
        }
    }

    public static void main(String[] args) {

        QueueArray<Integer> q = new QueueArray<>();
//        q.enqueue(5);
//        q.enqueue(6);
//        q.enqueue(6);
//        q.enqueue(6);
//        q.enqueue(6);
//        System.out.println(q.dequeue());
        Iterator i = q.iterator();
        while (i.hasNext()) {
            Object element = i.next();
            System.out.print(element + " ");
        }
        System.out.println(q.empty());
        System.out.println(q.full());

    }

}
