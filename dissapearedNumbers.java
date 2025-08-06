/**Time Complexity: O(n)[O(2n) and constant factors are ignored]
 * Space Complexity: O(1)
 * Did this code successfully run on leetcode: Yes
 * Any problems faced while coding this: No
 */

/**
 * We need to identify missing numbers in the range 1 to n. Since, the range is 1 to n the numbers when found are kept track of by making the number in the index current number-1 to negative
 * Here the numbers are marked negative to leave us with a way to identify the value at each index while traversing forward since we are mutating the original array.
 * After marking the existing numbers as negative, we traverse the array again and check for positive numbers to identify the missing numbers.
 **/
import java.util.ArrayList;
import java.util.List;
class dissapearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n=nums.length;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<=n-1;i++)
        {
            int num=Math.abs(nums[i]);
            int idx=num-1;
            if(nums[idx]>0)
            {
                nums[idx]=nums[idx]*-1;
            }
            else
                continue;

        }

        for (int i=0;i<=n-1;i++)
        {
            if(nums[i]>0)
            {
                result.add(i+1);
            }
        }
        return result;
        
    }
}