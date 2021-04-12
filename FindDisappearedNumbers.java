// Time Complexity : O(n), where n = length of array 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList();
        for(int num : nums){
            int idx = Math.abs(num) - 1;
            if(nums[idx]>0) nums[idx]*=-1;
        }
        List<Integer> result = new ArrayList();
        for(int  i=0;i<nums.length;i++){
            if(nums[i]>0) result.add(i+1);
        }
        return result;
        
    }
}