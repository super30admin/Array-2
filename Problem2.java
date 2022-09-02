import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public List<Integer> findMinMax(int[] nums){
        List<Integer> result = new ArrayList<>();
        // null check
        if(nums == null || nums.length == 0) return result;
        int min = nums[0];
        int max = nums[0];
        for(int i=0; i<nums.length; i+=2){
            if(nums[i]>nums[i+1]){
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            }
            else{
                max = Math.max(max, nums[i+1]);
                min = Math.min(min, nums[i]);
            }
        }
        result.add(min);
        result.add(max);

        return result;
    }
}
