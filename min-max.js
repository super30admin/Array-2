// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: not found on leetcode
// Any problem you faced while coding this: No

// [1, 3, 5, 2, 3, 7, 1]

const findMinMax = (nums) => {
  if (nums == null || nums.length == 0) return [];

  let min = Infinity,
      max = Number.NEGATIVE_INFINITY;

  for (const num of nums) {
    min = Math.min(num, min);
    max = Math.max(num, max);
  }
  return [min, max];
}
