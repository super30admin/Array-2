import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//iterate over the array, for each element set the element which has an index equal to
//the value of the element-1 as negative. This negative indicates that we have already
//encountered the element in the array. On the next pass check for the elements which
//does not have negative sign, these would give you the missing elements

class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> a = new ArrayList<Integer>();
        for(int i=0; i<len; i++){
            int num = Math.abs(nums[i]);
            if(nums[num-1] > 0){
                nums[num-1] *= -1;
            }
        }

        for(int i=0; i<len;i++){
            if(nums[i] > 0){
                a.add(i+1);
            } else {
                nums[i] *= -1;
            }
        }
        return a;
    }
}