public class DoublyLinkedList {
    class ValueNode {
        int data;  // Changed 'value' to 'data' for consistency
        ValueNode next;

        public ValueNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class Node {
        int key;
        Node prev, next;
        ValueNode valueHead;  // Head of the value list for this key

        public Node(int key, int data) {
            this.key = key;
            this.valueHead = new ValueNode(data);
        }
    }

    Node head, tail;

    // Method to insert a new key-value pair or append a new value for an existing key
    public void add(int key, int data) {
        Node node = findNode(key);
        if (node != null) {
            appendValue(node, data);  
        } else {
            Node newNode = new Node(key, data);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
    }

    // Append a new value to the value list for an existing key
    private void appendValue(Node node, int data) {
        ValueNode currentValueNode = node.valueHead;
        while (currentValueNode.next != null) {
            currentValueNode = currentValueNode.next;
        }
        currentValueNode.next = new ValueNode(data);
    }

    // Find the node for a given key
    private Node findNode(int key) {
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Delete a node by key
    public void remove(int key) {
        Node node = findNode(key);
        if (node == null) return;

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    // Find the first value for a given key
    public int search(int key) {
        Node node = findNode(key);
        return (node != null && node.valueHead != null) ? node.valueHead.data : -1;
    }

    // Get all the values for a given key as a formatted string
    public String getAllValues(int key) {
        Node node = findNode(key);
        if (node == null) return null;

        StringBuilder values = new StringBuilder();
        ValueNode currentValueNode = node.valueHead;
        while (currentValueNode != null) {
            values.append(currentValueNode.data);
            if (currentValueNode.next != null) {
                values.append(" -> ");
            }
            currentValueNode = currentValueNode.next;
        }
        return values.toString();
    }
}
