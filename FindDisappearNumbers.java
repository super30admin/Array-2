// Time Complexity : O(N) where N is number of elements in array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<Integer>();

        List<Integer> out = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0) {
                nums[idx] = nums[idx]*-1;
            }
        }

        for(int i = 0; i<nums.length; i++) {
            if(nums[i] > 0){
                out.add(i+1);
            } else {
                nums[i] = nums[i]*-1;
            }
        }
        return out;
    }
}