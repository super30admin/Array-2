import java.util.ArrayList;
import java.util.List;

public class DisappearedNoUsingIndex {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList();
		if (nums.length == 0 || nums == null) {
			return result;
		}
		for (int i = 0; i < nums.length; i++) {
			int a = Math.abs(nums[i]) - 1;
			if (nums[a] > 0) {
				int prod = nums[a] * -1;
				nums[a] = prod;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				result.add(i + 1);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		DisappearedNoUsingIndex var = new DisappearedNoUsingIndex();
		List<Integer> list = var.findDisappearedNumbers(new int[] { 4,3,2,7,8,2,3,1 });
		for (Integer a : list) {
			System.out.println(a);
		}
	}
}
