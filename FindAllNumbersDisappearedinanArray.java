package s30Coding;
import java.util.*;

//Time Complexity :- O(n)
//Space Complexity :- O(1);

//LeetCode :- Yes


public class FindAllNumbersDisappearedinanArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return result;
        }
        for(int i = 0; i < nums.length; i++){
            int temp = Math.abs(nums[i]) -1;
            if(nums[temp] > 0){
                nums[temp] *= -1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}
