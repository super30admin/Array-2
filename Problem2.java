//Problem: Find minimum and maximum of an array
// Time Complexity : O(1.5n) ~ O(n)
// Space Complexity : O(1)

//This approach reduces makes less than2 comparisions for each index. Each pair makes 3 comparisions so total time would be 3*(n/2)i.e. 1.5n
class MinMax{
    public static void main(String args[]){
        int[] arr = {2, -3, 1, 4, 8, 10, 15, -1};
        int n, max, min;
        n=7;
        min = arr[0];
        max = arr[0];
        
        for(int i=0; i<n; i= i+2){
            if(arr[i] < arr[i+1]){
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i+1]);
            }
            else{
                min = Math.min(min, arr[i+1]);
                max = Math.max(max, arr[i]);
            }
        }

        System.out.println("Minimum of an array: "+ min);
        System.out.println("Maximum of an array: "+ max);
    }
}