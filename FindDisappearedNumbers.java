// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

    public List <Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length ==0) {
            return new ArrayList <>();
        }

        int n = nums.length;
        for(int i =0; i<n;i++) {
            // find the suitable index for the number
            int index = Math.abs(nums[i])-1;

            // Make the number negative at the index place, so as to keep track what all numbers we have visited
            if(nums[index]>=0){
                nums[index] = nums[index]*(-1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i =0; i<n; i++) {
            // the numbers which are positive that means that index was not present as a number in the array, hence adding to the result list
            if(nums[i]>0) {
                ans.add(i+1);
            } else{
                // change the array back to its original state
                nums[i] = nums[i]*(-1);
            }
        }
        return ans;
    }
}
