// Time Complexity: O(n)
// Space Complexity: O(n)

public class MinimumAndMaximum{
    public static void Main(String args[]){
        int arr[] = {12,30,10,2,89,10};
        int min= arr[0];
        int max= arrr[0];
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
             if(arr[i]>max){
                max = arr[i];
            }
        }
        
        System.out.println("Minimum number in array: " + min);
        System.out.println("Maximum number in array: " + max);
    }
}