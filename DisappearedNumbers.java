import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        /*
        1. Get each element
        2. Subtract 1 from it and get the number
        3. Use this number as an index in the array
        4. Whatever is the element at the index make it negative
        5. This is the way of saying (index + 1) element is available in the input array
         */
        for(int i=0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }

        }

        for(int i=0; i < nums.length; i++){
            // Make all the elements back to positive. Otherwise, the else block logic will fail.
            if(nums[i] < 0){
                nums[i] = nums[i] * -1;
            }else {
                result.add(i + 1);
            }
        }

        return  result;
    }
}
