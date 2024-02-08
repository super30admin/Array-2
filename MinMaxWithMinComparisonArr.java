//Time Complexity = O(n) //Iterating entire nums array once.
//Space Complexity = O(1)
// Does it run on LeetCode successfully?: Didn't check on Leetcode
// Any difficulties: Odd even

/*
As we are running (n length array) 0 to n-2 loop which will keep checking all the pairs after checking current and next element.
Then check with min and max and based on that swap the values.

n length array - It is performing n/2 pairs. Each pair has 3 comparisons.
3n/2 comparisons happen. This is best case.

*/

public class MinMaxWithMinComparisonArr {
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    public void minMax(int[] nums) {
        int n = nums.length;
        for(int i =0; i<n-1; i+=2 ){
            if(nums[i] < nums[i+1]){
                min = Math.min(nums[i], min);
                max = Math.max(nums[i+1], max);
            }else{
                min = Math.min(nums[i+1], min);
                max = Math.max(nums[i], max);
            }
        }

        if(n%2 !=0) { //Odd length array handling
            if(nums[n-1] < min){
                min = nums[n-1];
            }
            if(nums[n-1]>max){
                max = nums[n-1];
            }
        }

        System.out.println("Min is : " + min);
        System.out.println("Max is : " + max);
    }

    public static void main(String[] args){
        MinMaxWithMinComparisonArr obj = new MinMaxWithMinComparisonArr();
        int[] nums = {5,8,1,6,-3};
        //null check on array happens here
        obj.minMax(nums);
    }
}