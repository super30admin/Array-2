//less the 2n comparisions
//Space Complexity: O(1) - not considering the min max items in the output list
//playgroundGFG: Yes

//Initialize the min and max with the first number.
//Compare in pairs and update the min and max. 


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        int[] arr = new int[]{2,8,6,2,11,5,70};
        int[] result = computeMaxMin(arr);
        System.out.println("Max:" + result[0] +" Min:" + result[1]);
    }
    
    
    private static int[] computeMaxMin(int[] arr) {
        int max, min;
        int index;
        
        if(arr.length%2 == 1) {
            max = arr[0];
            min = arr[0];
            index = 1;
        } else {
            if(arr[0] > arr[1]) {
                max = arr[0];
                min = arr[1];
            } else {
                min = arr[0];
                max = arr[1];
            }
            index = 2;
        }
        
        for(int i = index; i < arr.length - 1; i+=2) {
            if(arr[i] > arr[i+1]) {
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i+1]);
            } else {
                max = Math.max(max, arr[i+1]);
                min = Math.min(min, arr[i]);
            }
        }
        
        return new int[]{max, min};
    }   
}