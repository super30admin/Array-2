/*
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        if nums is None or len(nums) == 0:
            return result
        
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            
            if nums[index] > 0:
                nums[index] *= -1
        
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        return result
*/

// Time Complexity : O(n) where n is size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I leveraged the fact that range is from 1 to N where N is array size. Visited
// each index and subtracted 1 from it and then went to that index and made that element negative. In the end whatever element remains 
// positive that index+1 element is missing

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0){
            return result;
        }
        
        for (int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0){
                nums[index] *= -1;
            }
            
        }
        
        
        for (int i=0; i<nums.length; i++){
            if (nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}