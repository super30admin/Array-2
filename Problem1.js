// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


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

//Approach 2:  Space Complexity- O(1)
var findDisappearedNumbers = function (nums) {
    let result = []
    if (!nums || nums.length === 0) return result;

    for (let i = 0; i < nums.length; i++) {
        let idx = Math.abs(nums[i]) - 1;

        if (nums[idx] > 0) {
            nums[idx] = nums[idx] * (-1);
        }

    }

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] < 0) {
            nums[i] *= -1;
        } else {
            result.push(i + 1);
        }
    }
    return result;

};