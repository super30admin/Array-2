import java.util.ArrayList;
import java.util.List;

class DisappearedNumbersInArray {

    // Time Complexity : 0(n) where n is length of the array
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


    // Your code here along with comments explaining your approach: I first iterated over the array and subtracted each and
    //every element by 1. This gives us a valid index in the array. If there is a no. in the index, we assign it minus(basically marking
    //it as visited. If the no. i already market negative, we do nothing. Then, the concept is the index that is not marked
    //negative is the no. not present in the array or the missing no. Hence, we return the index + 1 of the missing index
    //to return the missing no.

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length == 0 || nums == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int difference = Math.abs(nums[i]) - 1;
            if(nums[difference] > 0){
                nums[difference] = nums[difference] * -1;
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