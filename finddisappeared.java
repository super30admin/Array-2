// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// if we have 2 in our array .. we are going to index 1 and making the element present there negative .. as we get negative values we are taking abs of the value and then subtracting it by 1
// now we are checking if the number is positive at any index then index+1 element is missing else we are multiplying the element with -1 
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0)
                nums[index]*=-1;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                arr.add(i+1);
            }
            else {
                 nums[i]*=-1;
            }
        }
    return arr;
    }
}