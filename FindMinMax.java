// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package com.dsa;

class FindMinMax {
    public int[] findMinMax(int[] nums) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length-1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //comparing first and last index at every iteration
        // updating min and max accordingly
        while(left<right){
            if(nums[left] < nums[right]) {
                min = Math.min(min, nums[left]);
                max = Math.max(max, nums[right]);
            } else {
                min = Math.min(min, nums[right]);
                max = Math.max(max, nums[left]);
            }
            left++;
            right--;
        }
        // when the nums array is of odd length, at one point, left and right will coincide
        // to capture that, this condition has been added
        if(left == right) {
            min = Math.min(min, nums[left]);
            max = Math.max(max, nums[right]);
        }
        result[0] = min;
        result[1] = max;
        return result;
    }
    public static void main(String[] args) {
        FindMinMax mm = new FindMinMax();
        int arr[] = { 1000, 11, 445, 1,2, 330, 3000 };
        int[] result = mm.findMinMax(arr);
        System.out.println("Min-->"+result[0]+" Max-->"+result[1]);
    }
}
