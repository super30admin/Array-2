import java.util.ArrayList;
import java.util.List;
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
This code finds all missing numbers in an array of size n where elements should be in the range [1, n].
It marks the presence of each number by negating the value at its corresponding index (nums[value - 1]).
In the second pass, any index still holding a positive value indicates a missing number,
which is added to the result list.
This approach modifies the array in place, achieving an O(n) time complexity with O(1) extra space.
By leveraging index manipulation,
it efficiently identifies missing elements without using extra data structures.
*/
class FindAllNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans=new ArrayList<>();



        for(int i=0;i<nums.length;i++)
        {
            int idx=Math.abs(nums[i]) - 1;
            if(nums[idx] > 0)
                nums[idx]*=-1;
        }



        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
                ans.add(i + 1);
        }
        return ans;
    }
}