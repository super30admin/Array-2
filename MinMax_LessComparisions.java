// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Comparing the numbers in pairs --to achieve less no of comparisions.
 * Ex: [4,2,3,6,1] ---first, compare 4 and 2 -> find localmin and localmax. COmpare localmin and min and the max and localmax--totally 3 comparisions
 * next move to: 3,6 --> thus instead of comapring each ele - min and max (2 comparisons for each ele)
 * over 3 elements -conventionally -6 comparisions but for pair compariosn method ..over 3 elements we have 3 comparisions.
 * Thus the comparsions are halved.
 */
class Solution{
    public static int[] findMinMax(int[] nums){
        if(nums == null || nums.length == 0) return new int[0];
        int min = nums[0],max = nums[0];
        for(int i=0;i<nums.length-1;i = i+2){
            int localmin,localmax;
            if(nums[i] <= nums[i+1]){
                localmin = nums[i];
                localmax = nums[i+1];
            }else{
                localmax = nums[i];
                localmin = nums[i+1];
            }
            min = Math.min(min,localmin);
            max = Math.max(max,localmax);
        }
        min = Math.min(min,nums[nums.length-1]);
        max = Math.max(max,nums[nums.length-1]);
        return new int[]{min,max};
    }
    public static void main(String[] args){
        int[] res = findMinMax(new int[]{4,6,2,1,7,3});
        System.out.println(res[0]+" "+res[1]);
    }
}