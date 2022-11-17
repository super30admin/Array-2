// Time Complexity : O (n)
// Space Complexity :O (1) // returning the result
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Logic: Subtracting 1 as size = length -1 and mutate the nums with negative value to find duplicates and missing values. The values with positive ones with index+1 is found as disappeared numbers

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
  if (nums.length === 0 || nums === null) return [];

  var n = nums.length;
  var result = new Array();

  for (var i = 0; i < n; i++) {
    var index = Math.abs(nums[i]) - 1;
    if (nums[index] > 0) {
      nums[index] = nums[index] * -1;
    }
  }
  for (var i = 0; i < n; i++) {
    if (nums[i] > 0) {
      result.push(i + 1);
    }
  }
  return result;
};
