package linkedlist;

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {
    Node head;

//     returns number of data elements in list
    public int size() {
        int size = 0;

        Node current = head;
        while(current != null) {
            current = current.next;
            size++;
        }

        return size;
    }

//    *bool returns true if empty */
    public boolean empty() {
        return this.head == null;
    }

//    returns the value of the nth item (starting at 0 for first)
    public Item valueAt(int index) {
        Node current = head;

        int i;
        for (i = 0; current != null & i < index; i++) {
            current = current.next;
        }

        if (i != index) {
            System.out.println("index out of bound");
            System.exit(0);
        }
        return (Item) current.item;
    }

//    adds an item to the front of the list
    public void pushFront(Item item) {
        Node newNode = new Node(item);
        newNode.next = head;
        this.head = newNode;
    }

//    remove front item and return its value
    public Item popFront() {
        if (this.empty()) {
            System.out.println("List is empty");
            System.exit(0);
        }
        Item value = (Item )head.item;
        this.head = head.next;
        return value;
    }

//    adds an item at the end
    public void pushBack(int item) {
        Node newNode = new Node(item);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

//    removes end item and returns its value
    public Item popBack() {
        if (this.empty()) {
            System.out.println("List is empty");
            System.exit(0);
        }

        Node current = head;
        Node prev = null;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        Item value = (Item) current.item;

        if (prev == null) { /*Chi co 1 ptu*/
            this.head = null;
        } else {
            prev.next = null;
        }

        return  value;
    }

//    get value of front item
    public Item front() {
        if (this.empty()) {
            System.out.println("List is empty");
            System.exit(0);
        }

        return (Item) this.head.item;
    }

//    get value of end item
    public Item back() {
        if (this.empty()) {
            System.out.println("List is empty");
            System.exit(0);
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        return (Item) current.item;
    }

//    insert value at index, so current item at that index is pointed to by new item at index
    public void insert(int index, int value) {
        Node current = head;
        Node prev = null;

        Node newNode = new Node(value);

        int i;
        for (i = 0; current!= null && i < index  ; i++) {
            prev = current;
            current = current.next;
        }

        if (i  != index) {
            //System.out.println(i);
            System.out.println("Index Out Of Bound");
            return;
        }

        if (prev == null) {
            newNode.next = head;
            this.head = newNode;
        } else  {
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

//    removes node at given index
    public void erase(int index) {
        if (this.empty()) {
            System.out.println("List is empty");
            System.exit(0);
        }

        Node current = head;
        Node prev = null;

        int i;
        for (i = 0; current != null && i < index; i++) {
            prev = current;
            current = current.next;
        }

        if (i != index) {
            System.out.println("Index Out Of Bound");
            return;
        }

        if (prev == null) {
            this.head =  current.next;
        } else {
            prev.next = current.next;
        }
    }

//    returns the value of the node at nth position from the end of the list
    public Item valueNFromEnd(int n) {
        if (this.empty()) {
            System.out.println("List is empty");
            System.exit(0);
        }

        Node current = head;
        Node match = head;

        int i;
        for(i = 0; current != null && i < n; i++) {
            current = current.next;
        }

        if (i != n) {
            System.out.println("Index Out Of Bound");
            System.exit(0);
        }

        while (current != null) {
            current = current.next;
            match = match.next;
        }

        return (Item)match.item;

    }

//    reverses the list
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.head = prev;
    }

//    removes the first item in the list with this value
    public void removeValue(Item value) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            if (current.item == value) {
                if (prev == null) { /*Node dau tien la node can xoa*/
                    this.head = current.next;
                } else {
                    prev.next = current.next;
                }
            }

            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.pushBack(5);
        linkedList.pushBack(6);
        linkedList.insert(0,4);
        linkedList.pushFront(1);

        Node temp = linkedList.head;

        while (temp != null ){
            System.out.println(temp.item);
            temp = temp.next;
        }
        System.out.println(linkedList.size());
        System.out.println(linkedList.empty());
        //System.out.println(linkedList.valueAt(5));
        System.out.println(linkedList.valueNFromEnd(1));
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
