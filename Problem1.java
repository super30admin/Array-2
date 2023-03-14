// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * We mark elements that we visited as -1, and go to nums[i] - 1 position and traverse accordingly. 
 * If the number is lesser than 0, we mark it positive. 
 * We add i+1 into our result array if it remains positive, as it is the missing element from our list. 
 */

class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int n = nums.length;
    if(n == 0 || nums == null)
    return res;
    for(int i =0; i < n;i++){
        int inx = Math.abs(nums[i]) -1;
        if(nums[inx] > 0)
            nums[inx] *= -1;
    }
    for(int i=0; i < n; i++){
        if(nums[i] > 0)
            res.add(i+1);
        else 
            nums[i] *= -1;
    }
    return res; 
    }
}