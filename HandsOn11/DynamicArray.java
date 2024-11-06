public class DynamicArray {
    private int[] data;       
    private int size;        
    private int capacity;     

    // Constructor with an initial capacity
    public DynamicArray(int initialCapacity) {
        data = new int[initialCapacity];
        size = 0;
        capacity = initialCapacity;
    }

    // Default constructor with a capacity of 2
    public DynamicArray() {
        this(4);
    }

    // to add an element at the end of the array
    public void pushBack(int value) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        data[size++] = value;
    }

    // to insert an element at a specific index
    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size == capacity) {
            resize(capacity * 2);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    // to delete an element at a specific index
    public void erase(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        if (size <= capacity / 4) {
            resize(capacity / 2);
        }
    }

    // to remove the last element (like pop_back in C++)
    public void popBack() {
        if (size > 0) {
            size--;
            if (size <= capacity / 4) {
                resize(capacity / 2);
            }
        }
    }

    // to resize the array to a new capacity
    private void resize(int newCapacity) {
        int[] newData = new int[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
        capacity = newCapacity;
    }

    // to get an element at a specific index (like operator[] in C++)
    public int at(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    // to get the current size of the array
    public int getSize() {
        return size;
    }

    // to get the current capacity of the array
    public int getCapacity() {
        return capacity;
    }

    // Override toString to display array contents
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DynamicArray dynArr = new DynamicArray();
        dynArr.pushBack(5);
        dynArr.pushBack(9);
        dynArr.pushBack(12);
        dynArr.pushBack(3);
        dynArr.pushBack(17);
        dynArr.pushBack(20);

        System.out.println("Elements: " + dynArr);
        System.out.println("Size: " + dynArr.getSize());
        System.out.println("Capacity: " + dynArr.getCapacity());

        dynArr.insert(5, 55);
        System.out.println("After inserting 55 at index 5: " + dynArr);

        dynArr.erase(4);
        System.out.println("After erasing element at index 6: " + dynArr);

        dynArr.popBack();
        System.out.println("After removing last element: " + dynArr);
        System.out.println("Size: " + dynArr.getSize());
        System.out.println("Capacity: " + dynArr.getCapacity());
    }
}
