/*
    Time Complexity = O(n)
    Space Complexity = O(1)
    Did this code successfully run on Leetcode : Didn't find leetcode question
    Number of comparisons: 3 for each pair of number i.e 3(n/2)
 */

package com.madhurima;

public class MinMaxInArray {

    public int[] findMinMax(int[] nums){
        if(nums == null || nums.length == 0){
            return new int[]{};
        }

        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int[] result = new int[2];

        for(int i = 0; i < n; i++){
            if(i == n-1){
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }else{
                if(nums[i] < nums[i+1]){
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i+1]);
                }else{
                    min = Math.min(min, nums[i+1]);
                    max = Math.max(max, nums[i]);
                }
            }
        }

        result[0] = min;
        result[1] = max;

        return result;

    }

    public static void main(String[] args){
        MinMaxInArray s = new MinMaxInArray();
        int[] nums = {4, 7, 2, 3, 10, 100, -1, 20};
        int[] result = s.findMinMax(nums);
        System.out.println("Min = " + result[0] + " , Max = " + result[1]);
    }

}
