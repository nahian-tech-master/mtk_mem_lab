import java.util.Scanner;

public class sltSort {
    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n]; // Create an array to store the elements
        System.out.print("Enter the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // Read elements into the array
        }

        sltSort tn = new sltSort();
        tn.sort(arr); // Call the sort method
        System.out.print("Sorted array: ");
        tn.printArray(arr); // Print the sorted array
    }
}


