// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We have given that elements in the array will in the range of 1 to n. So we can use indexes to keep track of elements
 * So for each num, we take its absolute value and we will go in the array at index (num-1) and will make the number present at that location negative, if not.
 * This way all the numbers we have visited their respective indexes will have negative values.
 * Once we have made changes for all elements in array, we will simply go through once again
 * This time, whichever index has positive element we can say that this number is positive because array does not have (index+1).
 * So we can find all missing numbers this way
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length;i++){
            int num = Math.abs(nums[i]);
            if(nums[num-1] > 0){
             nums[num-1] = nums[num - 1] * -1;   
            }
        }
        
        for(int i = 0; i < nums.length;i++){
            if(nums[i] > 0){
                ans.add(i+1);
            }
        }
        
        return ans;
    }
}