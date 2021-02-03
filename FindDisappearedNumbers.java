package S30.Arrays2;

/* Successfully executed on leetcode.
*   Time complexity: We are iterating over array twice it would still be O(n). n is length of array.
*  Space Complexity: Not using any extra space just modifying the given arrays. So, O(1).
*
*  Approach: While traversing every element in the array, we have to mark the elements index value
*            negative. This way we can remember if an element is visited. At the end all elements
*            in array indices will be marked negative except missing numbers indices. Iterate over
*            array to find positive numbers and return them.
* */

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String args[]){
        int[] a = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(a));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> missingNumbers = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int indexToBeMarked = Math.abs(nums[i]) -1;

            if(nums[indexToBeMarked] > 0)
                nums[indexToBeMarked] = -1 * nums[indexToBeMarked];
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0)
                missingNumbers.add(i+1);
        }
        return missingNumbers;
    }
}
