import java.util.ArrayList;
import java.util.List;
/*
Time Complexity: O(2n)
    One pass to make the presence by multiplying it with -1 O(n)
    Second pass to retrieve its values O(n)
    O(n) + O(n) = O(2n)

Space Complexity: O(1)

Did this code successfully run on Leetcode: Yes

Check video end if the input is negative, then to use this approach, find the min element in array say -3, so
adding 4 will give positive, so add offset 4 to every number in array and follow the below approach, in the end
before returning subtract 4
*/

class DisappearedNumbersNegative {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++)
        {
            int index = Math.abs(nums[i])-1;

            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] < 0) {
                nums[i] *= -1;
            } else {
                result.add(i+1);
            }
        }

        return result;
    }
}