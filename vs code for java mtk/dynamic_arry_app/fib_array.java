import  java.io.*;
import java.util.Scanner;
class fib_array{
    int fib(int n) {
        int arr[] = new int[n+1]; // Initialize the array with the appropriate size
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) { // Use a semicolon and correct the condition
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static void main(String args[]) {
        int n ;
        fib_array fibArray = new fib_array(); // Create an instance of the class
        Scanner fib = new Scanner(System.in);
        System.out.print("Talhas needs girls for kochlanor jonno: " );
        n = fib.nextInt();
        System.out.println(n + "th Fibonacci number is: " + fibArray.fib(n));
    }
}
