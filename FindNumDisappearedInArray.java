package DataStructure.Array;

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class S30_M_448_FindNumDisappearedInArray {
    public static void main(String[] args) {
        int[] nums = {1,1};
        findDisappearedNumbers(nums);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int current = Math.abs(nums[i]);
            nums[current-1] = -(Math.abs(nums[current-1]));
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]>0)
                result.add(i+1);
        }

        return result;
    }

    /*
    // My approach
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();  // S.C - O(N)
        int n = nums.length;

        int i=1;
        while(i<=n){
            map.put(i,0);
            i++;
        }

        for(int k: nums){  // T.C - O(n)
            if(map.containsKey(k)){
                map.put(k, k);
            }
        }

        for(Map.Entry m: map.entrySet()){
            if (m.getValue().equals(0)) {
                result.add((Integer) m.getKey());
            }
        }
        return result;
    }
    */

}
