// Time complexity is O(n) but 1.5(N-1) comparison
// Space complexity is O(1) as no extra space is used
public class MinimumAndMaximumNBigN31 {

	public void minAndMax(int[] nums) {
		// edge case
		if (nums.length == 0 || nums == null) {
			return;
		}
		int max = nums[0];
		int min = nums[0];

		for (int i = 1; i < nums.length; i = i + 2) {
			System.out.println(i);
			if (i == nums.length - 1) {
				max = Math.max(max, nums[i]);
				min = Math.min(min, nums[i]);	
			} else if (nums[i] > nums[i + 1]) {
				max = Math.max(max, nums[i]);
				min = Math.min(min, nums[i + 1]);
			} else {
				max = Math.max(max, nums[i + 1]);
				min = Math.min(min, nums[i]);
			}
		}
		System.out.println(max);
		System.out.println(min);
	}

	public static void main(String[] args) {
		MinimumAndMaximumNBigN31 sol = new MinimumAndMaximumNBigN31();
		int [] nums = {2,8,6,2,11,80,0,100};
		sol.minAndMax(nums);
	}
}
