import java.util.ArrayList;
import java.util.List;
//Time complexity: O(n)
//Space complexity: O(1)
//Approach: Iterate through array compare the crrent index value with current + 1 index value then compare the max and min
// of the current pair with the existing min max by applying Math.max and Math.min function return the final min and max.
public class FindMinMax {
    public static  List<Integer> findMaxAndMin(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length - 1; i+=2)   // i + 2 to reduce the time complexity from 2 to 1.5 ms
        {
            if(nums[i] < nums[i + 1])
            {
                // nums[i+1] is bigger than nums[i]
                max = Math.max(max, nums[i+1]);
                min  = Math.min(min, nums[i]);
            }
            else{
                // nums[i] is bigger than nums[i+1]
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(max);
        result.add(min);
        return result;
    }
    public static void main (String[] args){
        int nums[] = {1,8, 9, 10, 11, 12, 13, 14, 15, -1};
        List<Integer> result = findMaxAndMin(nums);
        System.out.println(result);
    }
}