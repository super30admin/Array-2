// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : From the concept of boolean array, making variation in the same array and
// identifying the duplicate numbers at the end


import java.util.ArrayList;
import java.util.List;

public class problem1 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res= new ArrayList<>();

        for(int i=0;i<nums.length;i++)
        {
            int idx=nums[i]-1;
            if(nums[i]>0)
            {
                nums[idx]*=-1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }


        return res;
    }
}
