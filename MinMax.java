// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] nums = {0,10,11,45,1,-1243,39,99,100,134,999};
        int[] result = minMax(nums);
        System.out.println(result[0]+" "+result[1]);
        
    }
    public static int[] minMax(int[] nums){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int i = 0;
        if(nums.length % 2 == 0) i=0;
        else{
            i = 1;
            min = Math.min(min, nums[0]);
            max = Math.max(max, nums[0]);
        };
        
        while(i<nums.length-1){
            if(nums[i] < nums[i+1]){
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i+1]);
            }
            else{
                System.out.println(nums[i+1]);
                min = Math.min(min,nums[i+1]);
                max = Math.max(max,nums[i]);
            }
            i = i+2;
        }
        return new int[]{min,max};
    }
}
