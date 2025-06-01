// # Array-2

// ## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : abs function made it easy, struggled a bit to find a work around

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    let res = []
    for(let i = 0;i<nums.length;i++){
        let index = Math.abs(nums[i]) - 1;
        if (nums[index] > 0) {
            nums[index] = -nums[index];
        }
    }
    for(let i=0;i<nums.length;i++){
        if(nums[i]>0) res.push(i+1)
    }
    return res

};
console.log(findDisappearedNumbers([4,3,2,7,8,2,3,1]))