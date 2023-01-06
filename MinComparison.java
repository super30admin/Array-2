// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach: In this approach we compare two elements at a time and we take the min of the smaller number and previous min.
//And max of bigger number an previous max. This way we can do 1.5n comparison instean of 2n if we compare each value with min and max.

public class MinComparison {

    static class pair {
        int min;
        int max;
    };
    pair getMinMax(int [] nums){

        pair minmax = new  pair();
        minmax.min = 1;
        minmax.max = 1;

        for(int i=0;i<nums.length; i+=2){
            if(nums[i]<nums[i+1]){
                minmax.min = Math.min(minmax.min,nums[i]);
                minmax.max = Math.max(minmax.max,nums[i+1]);
            }else{
                minmax.min = Math.min(minmax.min,nums[i+1]);
                minmax.max = Math.max(minmax.max,nums[i]);
            }
        }
        return minmax; //maxValue;
    }
}
