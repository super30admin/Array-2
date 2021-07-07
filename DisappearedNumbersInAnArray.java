// Time Complexity : O(n)
// Space Complexity : For Brute Force : O(n) For Optimized O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisappearedNumbersInAnArray {

    //Brute Force
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length; i++){
            set.add(nums[i]);
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }

        return list;
    }

    //With O(1) Space
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0){
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }

        return list;
    }

    public static void main(String args[]){
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
        System.out.println(findDisappearedNumbers1(nums));
    }
}
