
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :yes


// Your code here along with comments explaining your approach
/*Approach

1) calculate the index and calculate the value.
2) if number at index >0
    then the number is at -1;
3) if the number at index is positive 
    -> then the number at index should be added in array List in result.

*/


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> res = new ArrayList();
        
        for(int i=0;i<nums.length;i++)
        {
            int index= Math.abs(nums[i]);
            if(nums[index-1]>0)
            {
                nums[index-1]*=-1;
            }
            
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                res.add(i+1);
            }
        }
        
        return res;
    }
}