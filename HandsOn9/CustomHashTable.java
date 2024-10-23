public class CustomHashTable {
    private static final double MAX_LOAD_FACTOR = 0.75;
    private static final double MIN_SHRINK_FACTOR = 0.25;
    private static final int DEFAULT_CAPACITY = 20;

    private DoublyLinkedList[] bucketArray;
    private int elementCount;
    private int tableCapacity;
    private HashAlgorithm hashAlgorithm;

    // Constructor to initialize the hash table
    public CustomHashTable(HashAlgorithm hashAlgorithm) {
        this.tableCapacity = DEFAULT_CAPACITY;
        this.bucketArray = new DoublyLinkedList[tableCapacity];
        for (int i = 0; i < tableCapacity; i++) {
            bucketArray[i] = new DoublyLinkedList();
        }
        this.elementCount = 0;
        this.hashAlgorithm = hashAlgorithm;
    }

    // Method to insert key-value pair
    public void add(int key, int value) {
        if ((double) elementCount / tableCapacity >= MAX_LOAD_FACTOR) {
            adjustTableSize(tableCapacity * 2);
        }
        int index = hashAlgorithm.hash(key, tableCapacity);
        bucketArray[index].insert(key, value);
        elementCount++;
        showTable();  
    }

    // Method to remove key-value pair
    public void delete(int key) {
        int index = hashAlgorithm.hash(key, tableCapacity);
        bucketArray[index].delete(key);
        elementCount--;
        if ((double) elementCount / tableCapacity <= MIN_SHRINK_FACTOR && tableCapacity > DEFAULT_CAPACITY) {
            adjustTableSize(tableCapacity / 2);
        }
    }

    // Method to resize the hash table
    private void adjustTableSize(int newCapacity) {
        DoublyLinkedList[] oldBucketArray = bucketArray;
        bucketArray = new DoublyLinkedList[newCapacity];
        tableCapacity = newCapacity;
        elementCount = 0;  // Reset count and rehash
        for (int i = 0; i < newCapacity; i++) {
            bucketArray[i] = new DoublyLinkedList();
        }
        for (DoublyLinkedList list : oldBucketArray) {
            DoublyLinkedList.Node currentNode = list.head;
            while (currentNode != null) {
                DoublyLinkedList.ValueNode valueNode = currentNode.valueHead;
                while (valueNode != null) {
                    add(currentNode.key, valueNode.value);  
                    valueNode = valueNode.next;
                }
                currentNode = currentNode.next;
            }
        }
    }

    // Display method to show the table structure
    public void showTable() {
        System.out.println("Hash Table (Chaining):");
        System.out.println("----------------------");
        for (DoublyLinkedList list : bucketArray) {
            DoublyLinkedList.Node currentNode = list.head;
            while (currentNode != null) {
                System.out.print(currentNode.key + ": ");
                System.out.println(list.getAllValues(currentNode.key));
                currentNode = currentNode.next;
            }
        }
        System.out.println("----------------------");
    }

    // Method to find the value for a key
    public int search(int key) {
        int index = hashAlgorithm.hash(key, tableCapacity);
        return bucketArray[index].find(key);
    }

    // Hashing algorithm interface
    public interface HashAlgorithm {
        int hash(int key, int capacity);
    }

    // Division method hash function implementation
    public static class ModulusHashFunction implements HashAlgorithm {
        public int hash(int key, int capacity) {
            return key % capacity;
        }
    }

    // Multiplication method hash function implementation
    public static class MultiplyHashFunction implements HashAlgorithm {
        private static final double CONSTANT_A = 0.6180339887;  // Golden ratio constant

        public int hash(int key, int capacity) {
            return (int) (capacity * ((key * CONSTANT_A) % 1));
        }
    }
}
