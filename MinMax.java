// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Solution {
 
	public static void getMinMax(int[] nums) {
    
    if(nums == null || nums.length == 0) {
        return;
    }
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    if(nums.length == 1) {
        min = nums[0];
        max = nums[0];
        System.out.println("Min : " + min +"\nMax : " + max);
        return;
    }

    if(nums[0] > nums[1]) {
        min = nums[1];
        max = nums[0];
    }

    int i = 2;

    while(i <= nums.length - 2) {
        if(nums[i] > nums[i+1]) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i+1]);
        }
        else
        {
            max = Math.max(max, nums[i+1]);
            min = Math.min(min, nums[i]);
        }
        i += 2;
    }

    if(nums.length % 2 == 1) {
        max = Math.max(max, nums[nums.length - 1]);
        min = Math.min(min, nums[nums.length - 1]);
    }

    System.out.println("Min : " + min +"\nMax : " + max );


}
 
	public static void main(String[] args) {
		int a1[] = { 3, 4, 10, 6, 5, 1, 9, 12, 15, 11 };
		getMinMax(a1);
	}
}