package com.ds.rani.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 */

//Time complexity:o(n) where n is number of elements in array
//Space complexity:o(1)

//Approach:As numbers are from 1 to n take one number at a time from array and go to the index which is equal
// to value and make the value at that index negative.Finally add those indexes in the result whose value is positive
// here numbers are from 1-n so to fit those numbers in e 0-n indexes we have made it value-1
public class DisappearedNumbers {
    /**
     * @param nums input array
     * @return list of integers which are missing in array
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums==null || nums.length==0)
            return result;

        //Mark a[i] negative if value i present in array
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs( nums[i] ) - 1;
            if (nums[val] > 0)
                nums[val] = -nums[val];

        }
        //Add i in result if a[i] is positive
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                result.add( i + 1 );
        }

        return result;
    }
    public static void main(String[] args) {
        int arr[] = {4,3,2,7,8,2,3,1};
        System.out.println( DisappearedNumbers.findDisappearedNumbers( arr ) );
    }
}
