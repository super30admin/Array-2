// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;

public class DisappearedArray {
     public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n =nums.length;
        for(int i=0;i<n; i++)
        {
            int idx = Math.abs(nums[i]) -1;
            if(nums[idx] > 0)
            {
                nums[idx] *=-1;
            }

        }
        for(int i=0;i<n; i++)
        {
            
            if(nums[i] > 0)
            {
                result.add(i+1);
            }
            else
                nums[i] *= -1;
            
        }
        return result;
    }
    public static void main(String[] args)
    {
        int [] array = {4,3,2,7,8,2,3,1};
        DisappearedArray d =new DisappearedArray();
        System.out.println(d.findDisappearedNumbers(array).toString());
    }
}
