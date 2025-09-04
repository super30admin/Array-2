// Time complexity - O(n)
// Space complexity - O(1)
function findDisappearedNumbers(nums: number[]): number[] {
	let result = [];

	for (let i = 0; i < nums.length; i++) {
		const idx = Math.abs(nums[i]) - 1;
		if (nums[idx] > 0) {
			nums[idx] = -1 * nums[idx];
		}
	}

	for (let i = 0; i < nums.length; i++) {
		if (nums[i] > 0) {
			result.push(i + 1);
		}
	}

	return result;
}
