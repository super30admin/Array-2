// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
// Approach - use input array for advantage. loop in array, for each no. find id=abs(num)-1. if num[id]>0 then make it negative by * by -1. at the end, if any number is +ve then add that index+1 to output list.

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbersInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            int idx = Math.abs(nums[i]) - 1;    //taking abs for repeated no case which might be already -ve
            if(nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindDisappearedNumbersInArray solution = new FindDisappearedNumbersInArray();

        int[] nums1 = {4,3,2,7,8,2,3,1};
        List<Integer> result1 = solution.findDisappearedNumbers(nums1);
        System.out.println("Missing numbers for [4,3,2,7,8,2,3,1]: " + result1);

        int[] nums2 = {1,1};
        List<Integer> result2 = solution.findDisappearedNumbers(nums2);
        System.out.println("Missing numbers for [1,1]: " + result2);
    }
}
