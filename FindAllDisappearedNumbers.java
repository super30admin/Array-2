//TC: O(n)
//SC: O(1)
//approach: updating array inplace, with nums index at current nums value-1, to indicate it's present in the array

import java.util.ArrayList;
import java.util.List;

public class FindAllDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0)
                nums[index] = nums[index] * -1;
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }
}
