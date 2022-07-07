// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length==0){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int temp = Math.abs(nums[i]) - 1;
            if(nums[temp] > 0){
                nums[temp] = -1*nums[temp];
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
            else {
                nums[i] = -1*nums[i];
            }
        }
        return res;
    }
}