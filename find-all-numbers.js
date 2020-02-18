// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: yes
// Any problem you faced while coding this: I kept trying to do operations in place,
// but then checking for indices of negative numbers was causing issues (line 18, fixed now)

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
    if (nums == null || nums.length == 0) return [];

    let result = [];

    for (const num of nums) {
        let index = Math.abs(num) - 1;
        nums[index] = -Math.abs(nums[index]);
    }

    for (let i = 1; i <= nums.length; i++) {
        if (nums[i - 1] > 0) result.push(i);
    }

    return result;
};
