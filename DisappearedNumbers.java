// Time Complexity : O(n) where m and n are dimensions of matrix
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList();
        int[] hash = new int[nums.length];
        Arrays.fill(hash,0);
        for(int i=0;i<nums.length;i++){
            hash[nums[i]-1] = 1;
        }
        for(int i=0;i<hash.length;i++){
            if(hash[i]==0){
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String [] args){
        int [] nums = new int[]{4,3,2,7,8,2,3,1};
        DisappearedNumbers dn = new DisappearedNumbers();
        System.out.println(dn.findDisappearedNumbers(nums));
    }
}