//Time complexity is O(N) two for loop O(n)+ O(n) = O(2n) = O(n)
//Space complexity is O(1) as we are not using any extra space (result is output)
//This code is submitted on leetcode

import java.util.ArrayList;
import java.util.List;

public class MissingNumberBigN30 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> result = new ArrayList<>();
		if (nums.length == 0 || nums == null) {
			return result;
		}
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0)
				nums[index] *= -1;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				result.add(i + 1);
			}
		}
		return result;
	}
}
