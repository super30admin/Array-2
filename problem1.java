// Time Complexity :O(N^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

 // iterates through each element in the array and checks
// if it is already present in the ans list. If present, it removes that element from the list
import java.util.ArrayList;
import java.util.List;

public class problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++)
        {
            if(ans.contains(nums[i])) {
                ans.remove(Integer.valueOf(nums[i]));
            }

        }

        return ans;
    }
}
