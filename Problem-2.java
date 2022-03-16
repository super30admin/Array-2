// Time Complexity : O(N) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution{

    public static Pair<Integer,Integer> getMinMax(int[] arr){
        int max = Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<arr.length-1;i+=2){
            if(arr[i]>arr[i+1]){
                max=Math.max(max,arr[i]);
                min=Math.min(min,arr[i+1]);
            }
            else{
                max=Math.max(max,arr[i+1]);
                min=Math.min(min,arr[i]);
            }
        }
        return new Pair<Integer,Integer>(min,max);
    }
    public static void main(String[] args){
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        Pair<Integer,Integer> pair = getMinMax(arr);
        System.out.printf("\nMinimum element is %d", pair.getKey());
        System.out.printf("\nMaximum element is %d",pair.getValue());
    }
}