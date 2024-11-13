/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function (nums) {
  // Space O(N)
  let intermediateArray = new Array(nums.length);
  intermediateArray.fill(false);

  for (let index = 0; index < nums.length; index++) {
    intermediateArray[nums[index] - 1] = true;
  }

  let result = new Array();
  for (let index = 0; index < nums.length; index++) {
    if (intermediateArray[index] == false) {
      result.push(index + 1);
    }
  }
  return result;
};

var findDisappearedNumbersV2 = function (nums) {
  // Space O(1)
  for (let index = 0; index < nums.length; index++) {
    let numberPosition = Math.abs(nums[index]) - 1;
    if (nums[numberPosition] > 0) {
      nums[numberPosition] = nums[numberPosition] * -1;
    }
  }

  let result = new Array();
  for (let index = 0; index < nums.length; index++) {
    if (nums[index] > 0) {
      result.push(index + 1);
    }
  }
  return result;
};

test("Scenario #2: Happy Path", () => {
  let costs = [4, 3, 2, 7, 8, 2, 3, 1];
  expect(findDisappearedNumbersV2(costs)).toStrictEqual([5, 6]);
});

test("Scenario #2: Happy Path", () => {
  let costs = [1, 2, 2];
  expect(findDisappearedNumbersV2(costs)).toStrictEqual([3]);
});
