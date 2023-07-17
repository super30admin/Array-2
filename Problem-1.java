// Time Complexity : O(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.ArrayList;
import java.util.List;

//find the number at each index and go to number-1 index, multipy by -1
//in the end the numbers which are left positive give us the missing number, by thier index+1.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = nums.length;
        int j =0;
        for(int i =0; i<n; i++) {
            int temp = Math.abs(nums[i]);
            if(nums[temp-1]>0) {
                nums[temp-1] = nums[temp-1]*-1;
            }

        }

        for(int i =0; i<n; i++) {
            if(nums[i]>0) {
                result.add(j, i+1);
                j++;
            }

        }

        return result;
    }
}
