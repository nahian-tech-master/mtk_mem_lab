import java.util.Scanner;

public class Binary_Search {
    int bs(int arr[], int low, int high, int target){
        if(high>=low){
            int mid = low + (high-1) / 2;
            if (arr[mid]==target)
                return mid;
            
            else if(arr[mid] > target)
                return bs(arr, low , mid-1, target);
            
            else
                return bs(arr, mid+1, high, target);
        }
        return -1;
    }
   public static void main(String args[]){
//        int low = 0;
        Binary_Search ob = new Binary_Search();
        Scanner myObj = new Scanner(System.in);
        System.out.print("ENTER THE NUMBER OF ELEMENT: ");
        int n = myObj.nextInt();
        int arr[] = new int[n];
        System.out.print("ENTER THE ELEMENTS: ");
        for ( int i = 0; i < n; i++){
            arr[i] = myObj.nextInt();
            
        }
        System.out.print("ENTER THE VALUE TO FIND: ");
        int target = myObj.nextInt();
        int ans = ob.bs(arr, 0, n-1, target);
        if(ans == -1)
        {
            System.out.println("VALUE NOT FOUND IN THE ARRAY");
        }else System.out.println("VALUE FOUND AT INDEX: " + ans);
    }
}