// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;

class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int idx = nums[i];
            if(nums[i]<0) {
                idx = -1*idx;
                };
            if(nums[idx-1]>0){
                nums[idx-1] = -1*nums[idx-1];
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }

       public static void main(String[] args) {
        DisappearedNumbers obj = new DisappearedNumbers();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(obj.findDisappearedNumbers(nums));
        }
    }