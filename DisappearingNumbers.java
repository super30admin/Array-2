/*
Mark indices corresponding to numbers in the array as negative.
T.C = O(n)
S.C = O(1)
 */

import java.util.ArrayList;
import java.util.List;

public class DisappearingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i =0; i<nums.length;i++)
        {
            int index = Math.abs(nums[i]) - 1;

            if(nums[index]>0)
            {
                nums[index] *=-1;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i =0; i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                result.add(i+1);
            }
            else
            {
                nums[i]*=-1;
            }
        }
        return result;
    }
}
