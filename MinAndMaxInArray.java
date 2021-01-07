// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Compare the current element with the next element in array, and determine which is smaller or greater, then compare again with the overall min and max values.

public class MinAndMaxInArray {
    public static void main(String [] args){
        int[] nums = new int[]{4,6,8,2,3,5,9,5,99};

        int[] res = getMinAndMax(nums); 
        System.out.println(res[0]+","+res[1]);
    }

    public static int[] getMinAndMax(int[] nums) {

        if(nums == null || nums.length == 0) return new int[]{-1,-1};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length - 1 ; i = i + 2){
            if(nums[i] > nums[i+1]){
                if(nums[i] > max)
                    max = nums[i];
                if(nums[i+1] <min)
                    min = nums[i+1];
            } else {
                if(nums[i+1] > max)
                    max = nums[i+1];
                if(nums[i] <min)
                    min = nums[i];
            }
        }

        //check if number of elements in array are odd
        if(nums.length % 2 == 1){
            if(nums[nums.length - 1] < min)
                min = nums[nums.length - 1];
            if(nums[nums.length - 1] > max)
                max = nums[nums.length - 1];
        }

        return new int[]{min, max};
    }
}
