import java.util.Arrays;

class Stack {
    private int[] stackArray;
    private int top;
    private int maxSize;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }
    public void push(int value) {
        if (isFull()) {
            System.out.println("Is overflow: true");
        } else {
            stackArray[++top] = value;
            System.out.println("Pushed " + value + " to the stack.");
            printStack();
        }
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Cannot pop: stack is empty.");
            System.out.println("Is underflow: true");
            return -1;
        } else {
            int value = stackArray[top--];
            System.out.println("Popped " + value + " from the stack.");
            printStack();
            return value;
        }
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No element to peek.");
            return -1; 
        } else {
            return stackArray[top];
        }
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == maxSize - 1);
    }
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Current stack: Empty");
        } else {
            System.out.print("Current stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
}
public class Stackt {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
        }
        System.out.println("\nPushing elements onto the stack:");
        stack.push(15);
        stack.push(6);
        stack.push(2);
        stack.push(9);
        stack.push(17);

        System.out.println("Pushing 3:");
        if (stack.isFull()) {
            System.out.println("Stack is full: " + stack.isFull());
        }
        stack.push(3);

        System.out.println("Top element is: " + stack.peek());

        System.out.println("\nPopping elements from the stack:");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
        }

        stack.pop();
        System.out.println("Stack is empty: " + stack.isEmpty());
    }
}
