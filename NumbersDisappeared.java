// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: The optimal solution would be to store seen elements in a HashSet
// but instead of using a HashSet, we can modify the seen element as index and that 
// index's sign to be turned to negative. Now return those indices which didnt occur at all.
// (by using index+1 if index-1 was used previously). Return the new list of missing elements.


// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.List;
class NumbersDisappered {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        for(int i=0;i<nums.length;i++) {
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>0) result.add(i+1);
        }
        return result;
    }
}