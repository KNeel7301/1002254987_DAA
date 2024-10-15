class Queue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int maxSize;
    private int currentSize;

    public Queue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue overflow: Cannot enqueue " + value);
        } else {
            rear = (rear + 1) % maxSize;
            queueArray[rear] = value;
            currentSize++;
            System.out.println("Enqueued " + value + " to the queue.");
            printQueue();
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Cannot dequeue: Queue is empty.");
            return -1;
        } else {
            int value = queueArray[front];
            front = (front + 1) % maxSize;
            currentSize--;
            System.out.println("Dequeued " + value + " from the queue.");
            printQueue();
            return value;
        }
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    public boolean isFull() {
        return (currentSize == maxSize);
    }
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Current queue: Empty");
        } else {
            System.out.print("Current queue: ");
            for (int i = 0; i < currentSize; i++) {
                System.out.print(queueArray[(front + i) % maxSize] + " ");
            }
            System.out.println();
        }
    }
}

public class Queuet {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        }
        System.out.println("\nEnqueueing elements:");
        queue.enqueue(15);
        queue.enqueue(6);
        queue.enqueue(9);
        queue.enqueue(8);
        queue.enqueue(4);

        System.out.println("Enqueueing 17:");
        queue.enqueue(17);

        System.out.println("\nDequeuing elements:");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        }
        queue.dequeue();
    }
}
