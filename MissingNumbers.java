import java.util.ArrayList;
import java.util.List;
/**
 * Time complexity is O(n)
 * space complexity is O(1)
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for(int num : nums) {
            int a = num < 0 ? -1*num : num;
            if(nums[a-1] > 0) {
                nums[a-1] = -1 * nums[a-1];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
        
    }
}