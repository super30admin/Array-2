package com.ds.rani.array;


/**
 * Given an array of numbers of length N, find both the minimum and maximum.
 * Follow up : Can you do it using less than 2 * (N - 2) comparison
 */


//Approach:take first number as a minimum number as well as maximum number.
//Then traverse from the second number, and check if the current number is less than minimum number then assign it to min
// else check if it is greater than max number, if yes then assign it maxNumber
public class MinMaxNumber {

    //Time complexity:o(n) whwre n is number of elements in array
    //Space complexity:o(1)
    //Number of comparisons:3(n/2)=> 1.5(n)
    public static void findMinMaxWithLessComparisons(int[] nums) {

        if (nums == null || nums.length == 0)
            return;

        int minNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;
        int n = nums.length;
        int newl = n;
        //if its odd length array
        if (n % 2 != 0) {
            newl = n - 1;
        }

        for (int i = 0; i < newl; i = i + 2) {

            int localMin = 0;
            int localMax = 0;
            int num1 = nums[i];
            int num2 = nums[i + 1];

            //total (n/2) comparisons
            if (num1 < num2) {
                localMin = num1;
                localMax = num2;

            } else {
                localMax = num1;
                localMin = num2;
            }


            //total n/2 comparisons
            if (localMin < minNumber) {
                minNumber = localMin;
            }
            //total n/2 comparisons
            if (localMax > maxNumber) {
                maxNumber = localMax;
            }

        }

        //For odd length array compare last element withmin and max
        if(newl!=n){
            minNumber= Math.min(minNumber,nums[n-1]);
            maxNumber=Math.max(maxNumber,nums[n-1]);
        }
        System.out.println( "Min number: " + minNumber + " Max Number: " + maxNumber );
    }

    //Time complexity:o(n) whwre n is number of elements in array
    //Space complexity:o(1)
    //Number of comparisons:2(n-1)

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
            } else if (num < minNumber) {
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
        MinMaxNumber.findMinMaxNumbers( new int[]{4, 3, 2, 7, 8, 2, 3, 1} );

        MinMaxNumber.findMinMaxWithLessComparisons( arr );
        MinMaxNumber.findMinMaxWithLessComparisons( new int[]{3, 3} );
        MinMaxNumber.findMinMaxWithLessComparisons( new int[]{9, 8, 7, 6, 5, 4} );
        MinMaxNumber.findMinMaxWithLessComparisons( new int[]{4, 5, 6, 7, 8, 9, 10} );
        MinMaxNumber.findMinMaxWithLessComparisons( new int[]{4, 3, 2, 7, 8, 2, 3, 1} );
    }

}
