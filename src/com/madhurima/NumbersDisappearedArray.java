/*
    Time Complexity = O(n) //iterating from 1 to n numbers
    Space Complexity = O(1) //mutating given array only
    Did this code successfully run on Leetcode : yes
 */

package com.madhurima;

import java.util.ArrayList;
import java.util.List;

public class NumbersDisappearedArray {
}

class SolutionA {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for(int i  = 0; i < n; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0){
                nums[idx] *= -1;
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                result.add(i + 1);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        SolutionA s = new SolutionA();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(s.findDisappearedNumbers(nums).toString());
    }
}
