// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// It is using less than 2 * (N - 2) comparison to finding the value, compate 2 vaues
// at the same time, so get the least and hightest among both the number, and compare the min
// with the least and max with the highest
// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findingtheMinMax(int[] nums) {
        List<Integer> result = new ArrayList <>();
        if(nums == null || nums.length == 0) return result;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        // finding the min and max by comaring 2 values at a same time
        for(int i = 1 ; i < nums.length; i+2 ){
            if( nums[i-1] < nums[i]){
                min = Math.min(min, nums[i-1]);
                max = Math.max(max, nums[i]);
            }else {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i-1]);
            }
        }
        if( nums.length % 2 != 0){
            min = Math.min(min, nums[nums.length-1]);
            max = Math.max(max, nums[nums.length-1]);
        }
        result.add(min);
        result.add(max);
        return result;
    }
}