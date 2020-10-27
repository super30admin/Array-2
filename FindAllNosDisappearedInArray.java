package Oct27;

import java.util.ArrayList;
import java.util.List;

class FindAllNosDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
/* 
Time Complexity: O(n) where n is no.of elements in nums array.
Because we need to iterate through all elements of nums array.

Space Complexity: O(1)
No extra space used, so O(1).
      
Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this : No

Approach:
In place modification in the given array itself by negating technique and tracking the missed elements which have not been negated.
  
*/ 
        
        List<Integer> result = new ArrayList<>();
        
        // edge cases
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // negate all positive valued array elements which are at those index values such that index value = some input array element-1 
        // if an element has been negated already,it cannot be used directly to calculate index value using formula: input array element-1 
        // so take mod of the input array element whose value is negative and then calculate index value corresponding to it.
        for (int i = 0; i < nums.length; i++) {
            int curElem = nums[i];
            int posCurElem = Math.abs(curElem);
            int idx = posCurElem - 1;
            if (nums[idx] > 0) {
                nums[idx] = nums[idx] * -1;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            int curElem = nums[i];
            // if any element in the array is still positive => element(=index+1) corresponding to that index position was not present in the input array => add that missing element value(=index+1) to result list 
            if (nums[i] > 0) {
                result.add(i+1);
            }
            // restoring array element values to same as input by converting all negated values to positive back 
            else {
                curElem = curElem * -1;
            }
        }
        
        return result;
    }
}