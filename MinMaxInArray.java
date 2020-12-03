// Time Complexity :O(N) n are the number of elements in the given array.
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach: first considering every two elements as a pair and check the max of the pair
//with the max of the present traversed array and similarly for minimum. 
public class MinMax {
    public static void main(String[] args){
        int[] arr = new int[]{2,5,1,4,7};
        int[] result=calculate(arr);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
    public static int[] calculate(int[] arr){
        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        int temp;
        for(int i=0;2*i+1<arr.length;i++){
            if(arr[2*i]>arr[2*i+1]) {

                max = Math.max(max, arr[2 * i ]);
                min = Math.min(min, arr[2 * i+1]);
            }
            else {
                max = Math.max(max, arr[2 * i + 1]);
                min = Math.min(min, arr[2 * i]);
            }
            if(arr.length%2==1){
                max = Math.max(max, arr[arr.length-1]);
                min = Math.min(min, arr[arr.length-1]);
            }
        }
        return new int[]{min,max};
    }
}
