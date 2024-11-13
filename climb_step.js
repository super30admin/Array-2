/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
  let array = new Array(n + 1);
  array.fill(0);
  let steps = [1, 2];
  // array[0] = 1;

  for (let stepIndex = 0; stepIndex < steps.length; stepIndex++) {
    let step = steps[stepIndex];
    for (let position = 0; position <= n; position++) {
      if (step <= position) {
        array[position] = Math.max(1 + array[position - step], array[position]);
      }
    }
  }
  return array[n];
};

test("Scenario #2: Happy Path", () => {
  expect(climbStairs(2)).toStrictEqual(2);
});

test("Scenario #2: Happy Path", () => {
  expect(climbStairs(4)).toStrictEqual(5);
});
