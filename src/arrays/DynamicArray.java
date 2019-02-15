package arrays;

public class DynamicArray {
    private int array[];
    private int capacity;
    private int size;

    private final int kMinCapacity = 1;
    private final int kGrowthFactor = 2;
    private final int kShrinkFactor = 4;

    public DynamicArray() {
        array = new int[kMinCapacity];
        this.size = 0;
        this.capacity = kMinCapacity;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public int at(int index) {
        if (index < 0 || index >= size) {
            throw new Error("index out of range");
        }
        return array[index];
    }

    public void push(int item) {
        resize(size + 1);
        array[size] = item;
        this.size++;
    }

    public void resize(int candidateSize) {
        if (this.size < candidateSize) {
            if (this.size == this.capacity) {
                growSize();
            }
        } else if (this.size < candidateSize) {
            if (this.size == this.capacity/kShrinkFactor) {
                shrinkSize();
            }
        }
    }

    public void growSize() {
        int newArray[] = null;
        if (this.size == this.capacity) {
            newArray = new int[capacity * kGrowthFactor];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
        }

        this.array = newArray;
        this.capacity *= kGrowthFactor;
    }

    public void shrinkSize() {
        int newArray[] = null;
        if (this.size == this.capacity / kShrinkFactor) {
            newArray = new int[capacity / 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
        }

        this.array = newArray;
        this.capacity /= 2 ;
    }

    public void insert(int index, int item) {
        resize(size + 1);

        for (int i = size + 1; i >= index; i--) {
            array[i+1] = array[i];
        }

        array[index] = item;
        this.size++;
    }

    public void prepend(int item) {
        if (this.size == this.capacity) {
            growSize();
        }
        this.insert(0, item);
    }

    public int pop() {
        if (size <= 0) {
            System.out.println("nothing to pop");
        }

        resize(size - 1);
        int value = array[size-1];
        array[size - 1] = 0;
        this.size--;

        return value;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new Error("index out of range");
        }

        resize(size - 1);

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i+1];
        }
        array[size-1] = 0;
        this.size--;
    }

    public void remove(int item) {
        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                delete(i);
            }
        }
    }

    public int find(int item) {
        int foundIndex = -1;

        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                foundIndex = i;
            }
        }

        return foundIndex;
    }

    public static void main(String[] args) {

    }
}
