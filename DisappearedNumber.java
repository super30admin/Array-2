import java.util.*;

//Time Complexity : O(N) -> N is the number of elements in the array
//Space Complexity : O(1) -> we are not using any extra space for the result, we are modifying the input array
//Leetcode problem : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

/**
 * Iterate through the array, marking visited indices by negating the corresponding values.  
 * Traverse the array again to identify indices that remain positive, indicating missing numbers.  
 * Return a list of these missing numbers, as they were never marked during the first pass.  
 */

public class DisappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>(); 

        for(int i = 0; i < nums.length ; i++) {
            int currentNum = nums[i];
            if(currentNum < 0) currentNum = Math.abs(currentNum);
            if(nums[currentNum -1] > 0)
                nums[(currentNum-1)] *= -1; 
        }

        for(int i = 0; i <nums.length ; i++) {
            if(nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }
}
