import java.util.*;

//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList();

        for(int i=0 ; i<nums.length; i++){

            int val = Math.abs(nums[i]) - 1;

            if(nums[val] > 0){
                nums[val] *= -1;
            }

        }

        for(int i=0 ; i<nums.length; i++){

            if(nums[i] > 0){
                list.add(i+1);
            }

        }

        return list;
    }
}
