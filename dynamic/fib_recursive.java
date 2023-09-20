import java.util.Scanner;
import java.io.*;

class fib_recursive {
    
    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
    
    public static void main(String args[]) {
        fib_recursive ob = new fib_recursive();
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter the number for fibonacci series: ");
        int n = myObj.nextInt();
        System.out.println(n + "th Fibonacci number is: " + fib(n));
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

