class SinglyLinkedList {
    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Inserted " + data + " to the list.");
        printList();
    }

    public void delete() {
        if (head == null) {
            System.out.println("Cannot delete: List is empty.");
        } else {
            System.out.println("Deleted " + head.data + " from the list.");
            head = head.next;
            printList();
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("Current list: Empty");
        } else {
            System.out.print("Current list: ");
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class SinglyLinkedListT {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        if (list.isEmpty()) {
            System.out.println("List is empty.");
        }

        System.out.println("\nInserting elements:");
        list.insert(9);
        list.insert(25);
        list.insert(4);
        list.insert(1);
        list.insert(16);

        System.out.println("\nDeleting elements:");
        list.delete();
        list.delete();
        list.delete();
        list.delete();
        list.delete();

        if (list.isEmpty()) {
            System.out.println("List is empty.");
        }
        list.delete();
    }
}
