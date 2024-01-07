// Time Complexity : O(n) 
// Space Complexity : O(1)
// Approach : While iteration, make negative the value at calculted index to mark appeared numbers

var findDisappearedNumbers = function (nums) {
    const result = []
    for (let i = 0; i < nums.length; i++) {
        const idx = Math.abs(nums[i]) - 1
        if (nums[idx] > 0) {
            nums[idx] = nums[idx] * -1
        }
    }
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > 0) {
            result.push(i + 1)
        }
    };
    return result;
};