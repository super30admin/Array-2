// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>(nums.length);

        for(int i=0; i<nums.length; i++)
        {
            if(nums[Math.abs(nums[i])-1] > 0 )
                nums[Math.abs(nums[i])-1] *= -1;
        }

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] < 0 )
                nums[i] = nums[i] * -1;
            else
                list.add(i+1);
        }

        return list;
    }
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
