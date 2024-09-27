//Given an array of numbers of length N, find both the minimum and maximum. 
//Follow up : Can you do it using less than 2 * (N - 2) comparison

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : Compare pairs of numbers

//Compare pairs and set max and min as we go through whole array versus global max and global min

/**
 * @param {number[]} nums
 * @return {max and min}
 */
var findMinAndMax = function(nums) {
    let resultObj = {max:null,min:null};
    if(nums === null || nums.length === 0){
        return resultObj;
    }
    let max = nums[0];
    let min = nums[0];
    for(let i=0;i<nums.length;i=i+2){
        max = Math.max(max, Math.max(nums[i],nums[i+1]));
        min = Math.min(min, Math.min(nums[i],nums[i+1]));
    }
    resultObj.max = max;
    resultObj.min = min;
    return resultObj;
};