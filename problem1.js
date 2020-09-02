//// Time Complexity : O(n) we iterate the input 2 times
//// Space Complexity : O(1) since we use the input array and no additional space
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :
// just the mental intuition i would not come up with this algorithm

//// Your code here along with comments explaining your approach
var findDisappearedNumbers;

findDisappearedNumbers = function(nums) {
  var i, index, j, len, len1, num, output;
  if (nums === null || nums.length === 0) {
    return [];
  }
  output = [];
  for (i = 0, len = nums.length; i < len; i++) {
    num = nums[i];
    index = Math.abs(num) - 1;
    if (nums[index] > 0) {
      nums[index] *= -1;
    }
  }
  for (index = j = 0, len1 = nums.length; j < len1; index = ++j) {
    num = nums[index];
    if (nums[index] > 0) {
      output.push(index + 1);
    }
  }
  return output;
};

findDisappearedNumbers([-4, -3, -2, -7, 8, 2, -3, -1]);

//# sourceMappingURL=problem1.js.map
