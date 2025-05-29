/*
Intuition: take the index from current element, mark the element that you come across that index - 1 location as -ve if it isn't already
the numbers which are +ve are missing indices

time: O(n)
Space: O(1)
 */
import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i]) - 1] > 0){
                nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1]  * (-1);
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                output.add(i+1);
            }
        }

        return output;

    }
}
