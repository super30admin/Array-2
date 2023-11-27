// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


import java.util.ArrayList;
import java.util.List;

// For each of inp. no, mutate the input array to negate values at the current nums position i.e, in [val -1] pos
//Re-iterate through array and add left over positive nums,  (pos_num +1) to result list
public class MissingNums {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i< nums.length; i++){
            int pos = Math.abs(nums[i])-1;
            if(nums[pos]>0)
                nums[pos]=-1*nums[pos];
        }

        for(int i=0; i< nums.length; i++){
            if(nums[i]>0)
                res.add(i+1);
        }

        return res;

    }
    public static void main(String ar[]) {
        MissingNums m = new MissingNums();
        List<Integer> res = m.findDisappearedNumbers(new int[]{4,3,3,2});
    }
}