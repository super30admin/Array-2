package S30_Codes.Array_2;

import java.util.ArrayList;
import java.util.List;

// Time Complexit : O(n) // n = nums.length
// Space Complexity : O(1)
// Array-2

class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i=0; i<nums.length; i++){
            int num = Math.abs(nums[i]);
            if(nums[num-1] > 0)
                nums[num-1] *= -1;
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0)
                result.add(i+1);
        }

        return result;
    }
}