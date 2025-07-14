import java.util.ArrayList;
import java.util.List;

//TC: O(n)
//SC: O(1)
// Implemented using existing array and modifying the values in it.
class MissingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        for(int i = 0; i< nums.length; i++) {
            int index = Math.abs(nums[i]) -1;
            if(nums[index] > 0 ) {
                nums[index] *= -1;
            }

        }
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= nums.length; i++) {
            if(nums[i - 1] > 0) {
                res.add(i);
            }
        }
        return res;
    }
}