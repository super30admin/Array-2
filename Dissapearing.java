import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i : nums) {
            int pos = Math.abs(i) - 1;
            if(nums[pos] > 0) {
                nums[pos] *= -1;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) ans.add(i+1);
        }
        
        return ans;
        
    }
}