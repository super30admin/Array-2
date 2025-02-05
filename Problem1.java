import java.util.ArrayList;
import java.util.List;

// Time complexity o(n)
// space complexity o(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i]);
            if(nums[idx-1] > 0){
                nums[idx-1] *= -1;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}