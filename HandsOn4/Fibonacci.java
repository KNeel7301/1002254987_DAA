public class Fibonacci {

    public static int fib(int n) {
        System.out.println("fib(" + n + ") called");
        if (n == 0) {
            System.out.println("Returning 0 for fib(0)");
            return 0;
        }
        if (n == 1) {
            System.out.println("Returning 1 for fib(1)");
            return 1;
        }
        int result = fib(n - 1) + fib(n - 2);
        System.out.println("Returning " + result + " for fib(" + n + ")");
        return result;
    }

    public static void main(String[] args) {
        int n = 5;  
        System.out.println("Fibonacci of " + n + " is: " + fib(n));

        /*
        Expected Output for n = 5:

        fib(5) called
        fib(4) called
        fib(3) called
        fib(2) called
        fib(1) called
        Returning 1 for fib(1)
        fib(0) called
        Returning 0 for fib(0)
        Returning 1 for fib(2)
        fib(1) called
        Returning 1 for fib(1)
        Returning 2 for fib(3)
        fib(2) called
        fib(1) called
        Returning 1 for fib(1)
        fib(0) called
        Returning 0 for fib(0)
        Returning 1 for fib(2)
        Returning 3 for fib(4)
        fib(3) called
        fib(2) called
        fib(1) called
        Returning 1 for fib(1)
        fib(0) called
        Returning 0 for fib(0)
        Returning 1 for fib(2)
        fib(1) called
        Returning 1 for fib(1)
        Returning 2 for fib(3)
        Returning 5 for fib(5)
        Fibonacci of 5 is: 5
        */
    }
}
