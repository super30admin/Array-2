// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// iterated the aaray and negated the element at index position, reiterated array again and added the positive elements to the list and returned the list
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> output = new ArrayList<>();
        
        for(int num : nums){
            
            int index= Math.abs(num)-1;
            
           if(nums[index]>0){
               nums[index]*=-1;
           } 

        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                output.add(i+1);
            }
        }
        return output;
    }
}