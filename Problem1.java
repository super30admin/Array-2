import java.util.ArrayList;
import java.util.List;
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO
public class Problem1 {
    //approach -> as we know numbers are not sorted so we're gonna take the element, go the index which will be the value of the element
    //and mark it as -ve with this now every element which has appeared is marked as -ve to the index of the value of that element
    //run a loop to see which index is not -ve and return index+1 as we're starting from 0 index.
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ;i <n ;i++){
            //get the absolute value as the value could be -ve
            int indexValue = Math.abs(nums[i]);
            nums[indexValue-1] = Math.abs(nums[indexValue-1]) * -1;
        }
        for(int i = 0 ;i <n ;i++){
            if(nums[i] > 0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
