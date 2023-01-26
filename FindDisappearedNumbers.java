// Time Complexity : O(n)
// Space Complexity : O(1)

/*
 * we negate the elements in the list at that index. then add the elements 
 * to the list which are +ve.
 */

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i])-1] > 0){
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) arr.add(i+1);
        }
        return arr;
    }
}
