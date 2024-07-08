//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// To find the missing element, we create new array of same length as the nums array and fill it with -1,
// we then store the given values in new array's corresponding indices. 
// When we iterate over the new array, if any value has -1, then we determine the missing element.

// Your code here along with comments explaining your approach
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
    let checkNums = new Array(nums.length+1).fill(-1);
    let res = [];

    //place the elements in their indices
    for(let i=0; i<nums.length; i++){
        checkNums[nums[i]] = nums[i];
    }

    // Check the positions with missing elements i.e. containing -1 and we return those values 
    for(let i=1;i<=nums.length; i++){
        if(checkNums[i] === -1)
            res.push(i);
    }

    return res;
};