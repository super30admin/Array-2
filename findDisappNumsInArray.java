// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class findDisappNumsInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        
        for (int i = 0; i < nums.length; i++) {       
            //the index i becomes the new index we jump to, then mark as visited
            int idx = Math.abs(nums[i]) -1;
            
            if((nums[idx]) > 0){
                nums[idx] = nums[idx] * -1;
            }
        }
        
         for (int i = 1; i <= nums.length; i++) {
            //add the missing index to the result
             if(nums[i - 1] > 0) result.add(i);         
         }
        
        return result;
    }
}
