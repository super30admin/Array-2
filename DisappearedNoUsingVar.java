import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DisappearedNoUsingVar {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		List<Integer> res = new ArrayList();
		if (nums == null || nums.length == 0)
			return res;

		Arrays.sort(nums);

		int a = 1;
		int i = 0;
		if (nums.length == 2) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] != j + 1)
					res.add(j + 1);
			}
			return res;
		}
		while (a <= nums.length) {
			if (a == nums[i]) {
				a++;
				i++;
			} else if (a > nums[i]) {
				i++;
			} else {
				res.add(a);
				a++;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		DisappearedNoUsingVar var = new DisappearedNoUsingVar();
		List<Integer> list = var.findDisappearedNumbers(new int[] { 1, 1, 2, 2 });
		for (Integer a : list) {
			System.out.println(a);
		}

	}
}
