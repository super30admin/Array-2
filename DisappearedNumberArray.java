/*
 *  Time Complexity: O(N) where N is the length of the nums array.
 *  Space Complexity: O(1) Since we are mutating the existing array.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 *
 *  Explanation: For every value in the nums array we mark the number at that index  with a negative value. At the end all the indexes which are positive are the missing values since they did not appear in the nums array.
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList<Integer>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]>0) nums[Math.abs(nums[i])-1]=nums[Math.abs(nums[i])-1]*-1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) list.add(i+1);
        }
        return list;
    }
}
