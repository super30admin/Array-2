// Time Complexity : O(n); where n = length of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        // check if input array is null or empty
        if(nums == null || nums.length==0) return result;
        
        // find length of input array
        int n = nums.length;
        
        
        for(int i = 0; i < n; i++){
            
            // find index for the number that occured in input array
            int index = Math.abs(nums[i]) - 1;    // abs for making index positive if it has been set negative by other element's occurence
            
            // if number at that particular index is positive, make it negative
            if(nums[index] > 0){
                nums[index] *= -1;            
            }
        }
        
        for(int i = 0; i < n; i++){    
            
            // iterate through the array to find the positive elements which are disappeared and add to the result list
            if(nums[i] > 0){
                result.add(i+1);            
            }
            
        }
        
        return result;
    }
}