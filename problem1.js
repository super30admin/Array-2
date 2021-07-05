// ## Problem1 

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
// Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), 
// some elements appear twice and others appear once.

// Find all the elements of [1, n] inclusive that do not appear in this array.

// Could you do it without extra space and in O(n) runtime? You may assume 
// the returned list does not count as extra space.

// Example:

// Input: [4,3,2,7,8,2,3,1]

// Output: [5,6]

var findDisappearedNumbers = function(nums) {
    if(!nums || nums.length === 0) return nums;
    let res = [];
    for(let i = 0;i<nums.length;i++) {
        if(nums[Math.abs(nums[i])-1] > 0) nums[Math.abs(nums[i])-1] *= -1;
    }
    for(let j = 0;j<nums.length;j++) {
        if(nums[j] > 0) res.push(j+1);
    }
    return res;
};