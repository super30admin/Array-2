// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //State Change method
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                if(nums[nums[i]-1]>0) 
                    nums[nums[i]-1]*=-1;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                list.add(i+1);
            }
            else{
             nums[i]*=-1;
            }
        }
        return list;
    }
}
