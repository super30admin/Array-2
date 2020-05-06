package com.ds.rani.array;


/**
 * Given an array of numbers of length N, find both the minimum and maximum.
 * Follow up : Can you do it using less than 2 * (N - 2) comparison
 */

//Time complexity:o(n) whwre n is number of elements in array
//Space complexity:o(1)

//Approach:take first number as a minimum number as well as maximum number.
//Then traverse from the second number, and check if the current number is less than minimum number then assign it to min
// else check if it is greater than max number, if yes then assign it maxNumber
public class MinMaxNumber {
    /**
     * Given an array of n numbers find out minimum and maximum number from it
     *
     * @param nums array of integers
     */
    public static void findMinMaxNumbers(int[] nums) {

        if (nums == null || nums.length == 0)
            return;

        int minNumber = nums[0];
        int maxNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > maxNumber) {
                minNumber = num;
            } else if(num < minNumber)  {
                maxNumber = num;
            }

        }
        System.out.println( "Min number: " + minNumber + " Max Number: " + maxNumber );
    }

    public static void main(String[] args) {
        int arr[] = {4};
        MinMaxNumber.findMinMaxNumbers( arr );
        MinMaxNumber.findMinMaxNumbers( new int[]{3, 3} );
        MinMaxNumber.findMinMaxNumbers( new int[]{9, 8, 7, 6, 5, 4} );
        MinMaxNumber.findMinMaxNumbers( new int[]{4, 5, 6, 7, 8, 9, 10} );
        MinMaxNumber.findMinMaxNumbers( new int[]{4,3,2,7,8,2,3,1} );
    }

}
