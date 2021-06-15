// Time Complexity : O(n)
// Space Complexity : O(1)

class MinMax {
    
    private static int[] getMinMax(int[] arr){
        int min = arr[0];
        int max = arr[0];
        int startIndex = 1;
        //if arr is of even length
        if(arr.length % 2 == 0){
            if(arr[0] > arr[1]){
                max = arr[0];
                min = arr[1];
            }
            else{
                max = arr[1];
                min = arr[0];
            }
            //start from 3rd number
            startIndex = 2;
        }
        for(int i = startIndex; i < arr.length - 1; i+=2){
            if(arr[i] < arr[i + 1]){
                min = Math.min(min,arr[i]);
                max = Math.max(max,arr[i + 1]);
            }
            else{
                min = Math.min(min,arr[i + 1]);
                max = Math.max(max,arr[i]);
            }
        }
        return new int[]{min,max};
    }
 
    // Driver code
    public static void main(String args[]) {
        int arr[] = {8,1,4,3,9,2};
        int res[] = getMinMax(arr);
        System.out.printf("\nMinimum element is %d", res[0]);
        System.out.printf("\nMaximum element is %d", res[1]);
    }
}