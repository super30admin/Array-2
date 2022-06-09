/*
This approach finds the solution for the problem by keeping a record at each index of whether the
number exists or not. It does this by extracting the number at each index, and then going to the
index equal to the extracted number and flagging it. Eventually as it does this for all the numbers
in the array, there will be some indexes not flagged, which will be returned as the disappeared 
numbers.

Did this problem run on leetcode: Yes

Problems with this code: None
*/
class Solution {
    //Time complexity: O(n)
    //Space complexity: O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            int idx = Math.abs(nums[i]) - 1;
            //We flag the numbers by marking them as negative whenever we visit a particular index 
            if(nums[idx] > 0)
                nums[idx] *= -1;
        }
        
        for(int i = 0; i < nums.length; i++)
        {   //Amy numbers that are not negative are automatically filtered out
            if(nums[i] > 0)
                result.add(i+1);
        }
        
        return result;
    }
}