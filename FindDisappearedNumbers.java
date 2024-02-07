//TC - O(n)
//SC -O(1)
import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int idx = Math.abs(nums[i]) - 1;
			if (nums[idx] >= 0)
				nums[idx] = nums[idx] * -1;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				list.add(i + 1);

		}
		return list;

	}

	public static void main(String[] args) {
		int[] array = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> output = findDisappearedNumbers(array);
		System.out.println(output);
	}

}
