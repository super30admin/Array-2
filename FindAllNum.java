import java.util.*;

public class FindAllNum {
    public List<Integer> findAllNum1(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i=0; i<nums.length; i++){
            int curr = Math.abs(nums[i]);
            int numAtIdx = nums[curr-1];
            if (numAtIdx >0) {
                nums[curr-1] = nums[curr-1]* -1;
            } 
        }
        for (int i=0; i<nums.length; i++){
            if (nums[i] > 0) {
                ans.add(i+1);
            }
        }
        return ans;
    }
}
