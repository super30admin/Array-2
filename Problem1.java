// Time Complexity : O(n)
// Space Complexity : O(1) not considering the result list
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> li = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            
	    //if num exsits make its position negative
	    nums[index] = nums[index]>0 ? nums[index] * -1 : nums[index];
        }
        
	//add numbers respective to index whose values are positive
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0)
                li.add(i+1);
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]<0)
                nums[i] = nums[i] * -1;
        }
        
        return li;
    }
}