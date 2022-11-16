/* Problem 1 - Leetcode 448 - Find All Numbers Disappeared in an Array
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

// Your code here along with comments explaining your approach
const findDisappearedNumbers = (nums) => {
  // debugger;
  if (!nums.length) return [];
  const result = [];
  const n = nums.length;

  for (let i = 0; i < n; i++) {
    let idx = Math.abs(nums[i]) - 1;
    if (nums[idx] > 0) {
      nums[idx] = nums[idx] * -1;
    }
  }

  for (let i = 0; i < n; i++) {
    if (nums[i] > 0) {
      result.push(i + 1);
    } else {
      nums[i] = nums[i] * -1;
    }
  }
  return result;
};
