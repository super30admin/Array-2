/*Algorithm:
    1. Traverse through the array, go to the abs(nums[i])-1 index and multiply it with -1 if its not negative already.
    2. Traverse through the nums array, if an element is positive then add respective index+1 in the list.
    3. Return the list.
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Did the code run on the leetcode? Yes
    
    
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        if(nums.length==0 || nums==null)
            return result;
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0)
                nums[index]*=-1;
        }
        
        //[0,1,2,3,4,5,6,7]
        //[-4,-3,-2,-7,8,2,-3,-1]
        // Missing numbers -> 5 and 6
        for(int i=0; i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        
        return result;
        
    }
}