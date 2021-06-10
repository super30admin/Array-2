// Time Complexity : O(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                if(nums[nums[i]-1] > 0){
                    nums[nums[i]-1] = -1 * nums[nums[i]-1];
                }
            }
            else{
                int pos = -1 * nums[i];
                    if (nums[pos-1] > 0){
                    nums[pos-1] = -1 * nums[pos-1];
                    }
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
            else{
                nums[i] = -1 * nums[i];
            }
        }
        
        return result;
    }
}