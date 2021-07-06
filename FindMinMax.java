// Time Complexity : O(n) where n is the length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public class Main {
    public static int [] findMinMax(int[] nums){
        if(nums == null || nums.length == 0) return new int[]{};
        int min = nums[0];
        int max = nums[0];
        
        for(int i = 0; i <nums.length; i += 2){
            if(nums[i] > max)
                max = nums[i];
            
            if(nums[i] < min)
                min = nums[i];
        }
        return new int[]{min,max};
    }

    public static void main(String[] args) {
      int[] nums = {12,4,3,2,4,3,3,33,22,2,22,2,22,22,5,56,5,5,5,5,934,4,343,3344,7677,7767,8878,978667,567,77,86};
      int[] result = findMinMax(nums);
        System.out.println(result[0]+" "+ result[1]);
    }
}