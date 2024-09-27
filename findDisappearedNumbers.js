// Time Complexity : O(n) where n is nums length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} nums
 * @return {number[]}
 */
 var findDisappearedNumbers = function(nums) {
    let result = [];
    for(let i=0; i< nums.length; i++) {
        let index = Math.abs(nums[i]) - 1;
        if(nums[index] > 0) nums[index] *= -1;
    }
    for(let i=0; i< nums.length; i++) {
        if(nums[i] > 0) result.push(i+1);
        else nums[i] *= -1;
    }
    return result;
};