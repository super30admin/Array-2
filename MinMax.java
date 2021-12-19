// Time Complexity : O(n)
// number of comparisons : 1.5n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not a leetcode question
// Any problem you faced while coding this : no

public class MinMax {

    int min;
    int max;

    public MinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }

    MinMax findMinMax(int [] nums) {
        int localMin = Integer.MAX_VALUE;
        int localMax = Integer.MIN_VALUE;
        int i = 0;
        while(i< nums.length-1) {
            // we take a pair and do comparison between them
            // whichever is greater, it is a candidate for max element
            //other one is for min element
            if(nums[i] < nums[i+1]) {
                localMax = Math.max(localMax, nums[i+1]);
                localMin = Math.min(localMin, nums[i]);
            } else {
                localMax = Math.max(localMax, nums[i]);
                localMin = Math.min(localMin, nums[i+1]);
            }
            i = i+2;
        }
        // this is to handle the odd number of elements in an array
        // we will compare it with both
        if( i == nums.length-1) {
            localMin = Math.min(localMin, nums[i]);
            localMax = Math.max(localMax, nums[i]);
        }
        return new MinMax(localMin, localMax);
    }

}
