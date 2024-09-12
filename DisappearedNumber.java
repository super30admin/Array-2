import java.util.*;

public class DisappearedNumber {

	//	Time:  O(m*n) 
	//	Space O(m*n)
	//	LeetCode: yes

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List <Integer> result = new ArrayList<Integer>();
		
		//first pass - make nums[i] negative
		for(int i = 0; i < nums.length; i++){
			int temp = nums[i];
			if(temp < 0){
				temp *= -1;
			}
			if(temp <= nums.length) {
				if(nums[temp - 1] > 0){
					nums[temp-1] *= -1;
				}
			}
		}
		//second pass if nums[i] > 0, add to result
		for(int i = 0; i < nums.length; i++){
			if(nums[i] > 0){
				result.add(i+1);
			}
		}
		return result;
	}
}
