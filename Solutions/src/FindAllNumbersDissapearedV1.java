import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this : Failed [1,1] test case


// Your code here along with comments explaining your approach
class FindAllNumbersDissapearedV1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length==0){
            List<Integer> a = new ArrayList<Integer>();
            return a;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i=1;i<max+1;i++){
            if (!set.contains(i)){
                result.add(i);
            }
        }
        return result;

    }
}
