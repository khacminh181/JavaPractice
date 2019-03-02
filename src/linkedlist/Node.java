package linkedlist;

import java.util.Iterator;

public class Node<Item> implements Iterable<Item> {
    public Item item;
    public Node next;

    public Node() {

    }

    public Node(Item item, Node next) {
        this.item = item;
        this.next = next;
    }

    public Node(Item item) {
        this(item, null);
    }


    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}


