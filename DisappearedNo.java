//TC: O(N) where N represents the elements in array and since we are traversing the array only twice.
// SC: O(1) since they have mentioned that extra space for ArrayList should not be considered.

// We are storing the numbers in their respective indices so that we can retrieve the array. If the number at that particular index is 0, we will /
// add that index to our resulting list.


import java.util.*;

public class DisappearedNo {
	
	public List<Integer> findDisappearedNumbers(int[] nums){
		
		int[] val = new int[nums.length+1];
		List<Integer> res = new ArrayList<>();
		
		for(int i=0;i<nums.length;i++) {
			val[nums[i]] = nums[i];
		}
		
		for(int i=1;i<val.length;i++) {
			if(val[i]==0)
				res.add(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		DisappearedNo dno = new DisappearedNo();
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> list = dno.findDisappearedNumbers(nums);
		
		for(int res: list)
			System.out.print(res+" ");
	}

}
