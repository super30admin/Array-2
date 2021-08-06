/* Time Complexity :  O(n)
   Space Complexity :  O(1)
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int index = Math.abs(nums[i])-1; //go to the ith element index and make it negative - to indicate the element is present and not missing
            if(nums[index]>=0)
                nums[index]=nums[index]*-1;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0) //Element missing case if positive
            {
                res.add(i+1);
            }
            else
            {
                nums[i] = nums[i]*-1; //making the original array
            }
        }
        return res;
    }
}