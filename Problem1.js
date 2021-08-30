// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//// Any problem you faced while coding this : Follow up question of reducing extra space

var findDisappearedNumbers = function (nums) {
    let frequencyCounter = {};
    for (let num of nums) {
        frequencyCounter[num] = (frequencyCounter[num] || 0) + 1;
    }
    // console.log(frequencyCounter);
    let result = [];
    for (let i = 1; i <= nums.length; i++) {
        if (!frequencyCounter[i]) result.push(i);
    }

    return result;
};