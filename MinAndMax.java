// Time Complexity:  O(n) with reduction in number of comparisions
// Space Complexity: O(1)

public class findMinAndMax{

    static int[] getMinMax(int[] arr){
        
        int min;
        int max;
        int size = arr.length;
        int sIndex = 0;
        
        if(size % 2 == 0){
            if(arr[0] > arr[1]){
                max = arr[0];
                min = arr[1];
            } else {
                max = arr[1];
                min = arr[0];
            }
            sIndex = 2;
        } else {
            min = arr[0];
            max = arr[1];
            sIndex = 1;
        }
        
        for(int i=sIndex; i< arr.length-1; i+=2){
            if(arr[i] > arr[i+1]){
                max = Math.max(max, arr[i]);
                min = Math.min(min,arr[i+1]);
            } else {
                max = Math.max(max,arr[i+1]);
                min = Math.min(min,arr[i]);            
            }
        }

        int[] result = {min, max};
        return result;
    }

    public static void main(String args[]) {
            int arr[] = {6,5,4,3,2};
            int[] output = getMinMax(arr);
            System.out.println("Min element is:" + output[0]);
            System.out.println("Max element is:" + output[1]);

        }
}