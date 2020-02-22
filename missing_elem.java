// Time Complexity : O(N) iterated over array elements
// Space Complexity : O(1) no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve this way before class


// Your code here along with comments explaining your approach: 
//Iterate over array elements to find which elements present. Mark the corresponding elements in the index -ve.
//Then iterate to find which elements are positive.
//return the index of those positive elements + 1.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        //list to return result
        List<Integer> res = new LinkedList<>();
        
        //base checks
        if(nums == null || nums.length == 0) return res;
        
        //loop to calculate new index and if that appears mark it to -ve
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            
            if(nums[index] >0){
                nums[index] *= -1;
            }
        }
        
        //loop to find out +ve numbers and return the index into result list
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
            if(nums[i] >0){
                res.add(i+1);
            }
        }
        
        return res;
    }
}