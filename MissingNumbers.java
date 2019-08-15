import java.util.ArrayList;
import java.util.List;

public class MissingNumbers {
	/**
	 * Time: O(n)
	 * Space: O(1)
	 * Leetcode accepted: yes
	 * Problems faced: No
	 */
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<nums.length; i++) {
			//If not already negative, mark the corresponding element at its original index as negative
			int index = Math.abs(nums[i])-1;
			if(nums[index] > 0) {
				nums[index] = nums[index]*-1;
			}
		}
		//Remaining positive elements is the result
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > 0) {
				result.add(i+1);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers(nums));
	}

}
