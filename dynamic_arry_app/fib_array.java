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
        fib_array fibArray = new fib_array(); // Create an instance of the class
        Scanner fib = new Scanner(System.in);
        System.out.print("Enter the number for fibonacci series: ");
        int n = fib.nextInt();
        System.out.println(n + "th Fibonacci number is: " + fibArray.fib(n));
        int array[] = new int[n];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
           array[i] = array[i - 1] + array[i - 2];
        }
        System.out.print("Fibonacci Series:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + ", ");
        } 
        System.out.println();
    }
}