
/**
 * # Idea
 *  1. Since, we only have elements from [1...n]. Iterate array and make the element -ve and insert into the array with the value as position.
 *  2. This process makes all elements other than missing indexes as -ve. Iterate again and add (index+1) to result.
 * # Time Complexity: O(n)
 * # Space Complexity: O(1) - no extra space other than result
 * Did this code successfully run on Leetcode : Yes
 */

import java.util.*;

class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0) return result;

        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0)
                nums[index] = -1 * nums[index];
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0)
                result.add(i+1);
        }

        return result;
    }
    public static void main(String[] args){
        System.out.println("DisappearedNumbers");
        DisappearedNumbers obj = new DisappearedNumbers();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(obj.findDisappearedNumbers(nums));
    }
}