// Time Complexity : O(N) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            
            if(nums[index]>0)
                nums[index]*=-1;
        }
            
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]>0)
                list.add(i);
        }
        return list;
    }
}