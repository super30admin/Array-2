import java.util.ArrayList;
import java.util.List;

//TC - O(N)
//SC -O(1)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
public class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                res.add(i+1);
            }else{
                nums[i]*=-1;
            }
        }
        return res;

    }
}
