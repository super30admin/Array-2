// Time Complexity : O(n)
// Space Complexity : O(1) - constant: since we update the array in-place
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

var findDisappearedNumbers = function (nums) {
  const resultsArr = [];

  for (let i = 0; i < nums.length; i++) {
    const indexToBeUpdated = Math.abs(nums[i]) - 1;
    nums[indexToBeUpdated] = Math.abs(nums[indexToBeUpdated]) * -1;
  }

  for (let j = 0; j < nums.length; j++) {
    if (nums[j] > 0) {
      resultsArr.push(j + 1);
    }
  }

  return resultsArr;
};

console.log(findDisappearedNumbers([1, 1]));

// Alternate approach with worse space complexity:
// TC: O(n) Linear time
// SC: O(n) Linear space
// var findDisappearedNumbers = function (nums) {
//   const numsSet = new Set();
//   const resultsArr = [];

//   for (let i = 0; i < nums.length; i++) {
//     numsSet.add(nums[i]);
//   }

//   for (let i = 1; i < nums.length + 1; i++) {
//     if (!numsSet.has(i)) {
//       resultsArr.push(i);
//     }
//   }

//   return resultsArr;
// };

// console.log(findDisappearedNumbers([1, 1, 2, 4]));
