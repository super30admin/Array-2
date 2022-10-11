// Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

// Time Complexity : O(m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function (nums) {
    if (nums === null || nums.length === 0) {
        return [];
    }
    for (let i = 0; i < nums.length; i++) {
        // If a number is present, mark its index i.e num-1 as negative
        // If it is already negative, dont do anything
        let idx = Math.abs(nums[i]) - 1;
        if (nums[idx] > 0) {
            nums[idx] *= -1;
        }
    }
    let ans = [];
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > 0) {
            // If number is positive, this index was not touched. So the number index+1 is not present in the array
            ans.push(i + 1);
        } else {
            // Revert original array
            nums[i] *= -1;
        }
    }

    return ans;
};