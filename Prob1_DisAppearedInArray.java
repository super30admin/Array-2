// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      List<Integer> list = new ArrayList<>();
        
        if(nums == null || nums.length == 0)    return list;
        
        for(int i = 0; i< nums.length; i++){
            if(nums[Math.abs(nums[i]) - 1] > 0){
                nums[Math.abs(nums[i]) - 1] *= -1;
            }//Making the element -ve with resptect to its index like if A[i] = 4, means 4 is in the array so, we will male an element -ve at index 4.
        }
        
        for(int i = 0; i< nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);//If element is positive means index+1 is not in the array
            }
        }
        
        return list;
    }
}
