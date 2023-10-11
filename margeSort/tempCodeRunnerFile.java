public class margeSort {
    void marge(int arr[], int low , int high){
        if(low<high){
            int mid = low + (high - low)/2;
            marge(arr,low,mid);
            marge(arr, mid+1, high);
            sort(arr, low, mid , high);
        }
    }
    void sort(int arr[], int low, int mid , int high){
        int h = low, i = low, j = mid+1; 
        int b[] = new int [high+1];
        while(h<=mid && j<=high){
            if (arr[h]<=arr[j]){
                b[i] = arr[h];
                h++;
            }else
            {
                b[i] = arr[j];
                j++;
            }
            i++;
        }
        if(h>mid){
            for(int k=j; k<=high; k++){
                b[i] = arr[k];
                i++;
            }
        }else{
            for(int k=h; k<=mid; k++){
                b[i] = arr[k];
                i++;
            }
        }
        for(int k = low; k<=high; k++){
            arr[k] = b[k];
        }
    }
    public static void main(String args[]) {
        int arr[] = {10, 90, 20, 30, 50};
        margeSort obj = new margeSort();
       int n= arr.length;
       obj.marge(arr, 0 , n-1);
        // Print the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
