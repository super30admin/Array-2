// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: used hashset to store the elements of the array and then checked for the missing elements from 1 to n and added them to the result list.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
 
    class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }

        for(int i=1; i<=n; i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }

        return result;
    }
}


