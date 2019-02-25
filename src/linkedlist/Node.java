package linkedlist;

public class Node {
    int item;
    Node next;

    public Node(int item, Node next) {
        this.item = item;
        this.next = next;
    }

    public Node(int item) {
        this(item, null);
    }


}


