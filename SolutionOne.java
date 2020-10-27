// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes


// Your code here along with comments explaining your approach
/*Just change the no present at the index to negative
* Pick the index of remaining positive no's
* */

class SolutionOne {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new LinkedList<Integer>();

        for(int i=0;i<nums.length;i++)
        {
            int index=Math.abs(nums[i])-1;

            if(nums[index]>0)
            {
                nums[index]=nums[index]*-1;
            }
        }

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
                result.add(i+1);
        }

        return result;
    }
}