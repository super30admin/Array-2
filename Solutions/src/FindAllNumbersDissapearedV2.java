// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this : No
import java.util.ArrayList;
import java.util.List;

class FindAllNumbersDissapearedV2 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length==0){
            List<Integer> a = new ArrayList<Integer>();
            return a;
        }

        for (int i = 0;i < nums.length;i++){
            int  val =Math.abs(nums[i])-1;
            if (nums[val]>0){
                nums[val] = -nums[val];
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0;i < nums.length;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }
        return res;
    }
}