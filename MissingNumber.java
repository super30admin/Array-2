// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res= new ArrayList<>();
    int len = nums.length;

    for (int i=0;i<len;i++){
        int index = Math.abs(nums[i]);
        if(nums[index-1]>=0){
        nums[index-1]*=-1;
        }
    }

    for (int i=0;i<len;i++){
        System.out.println(nums[i]);
    }

    for (int i=0;i<len;i++){
        if(nums[i]>0){
            res.add(i+1);
        }else{
        nums[i]*=-1;
        }
    }


    return res;
    }

}