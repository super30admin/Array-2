import java.util.ArrayList;
import java.util.List;


/* 
 * Complexity of algorithm is O(n), where n is number of the elements in a array.
 *  
 * */

public class FindAllNumbersDisappearedinanArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {

		if (nums == null || nums.length == 0)
			return new ArrayList();

		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {

			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0) {
				nums[index] = nums[index] * (-1);

			}

		}

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] > 0) {
				result.add(i + 1);
			} else {
				nums[i] = nums[i] * (-1);
			}
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };

		FindAllNumbersDisappearedinanArray objIn = new FindAllNumbersDisappearedinanArray();

		System.out.println(objIn.findDisappearedNumbers(nums));

	}

}
