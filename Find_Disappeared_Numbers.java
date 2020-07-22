/***********************Using Extra Space******************/
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* Store all the unique numbers in an array using set
 * iterate through the array and if set does't contains the index then store that in list
 * return the list for disappeared numbers*/
import java.util.*;

public class Find_Disappeared_Numbers {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		
		for(int i=0; i<nums.length; i++)
			set.add(nums[i]);
		
		for(int i=1; i<=nums.length; i++) {
			if(!set.contains(i))
				list.add(i);
		}
		return list;
	}

	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.print(findDisappearedNumbers(nums));
	}

}


/***********************In place sort Approach******************/
//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
/* By going through array, if the index is present as number in the array, change the number to negative, if its duplicate number, dont change anything as its already modified as negative number
 * Return the numbers of the indices that are positive in the array.*/

public class Find_Disappeared_Numbers {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int temp = nums[i];
            if(temp < 0)
                temp = temp * -1;
            if(nums[temp-1] > 0)		//go to each nums[temp-1] index and make it -nums[temp-1] if its not negative
                nums[temp-1] = nums[temp-1] * -1;
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }

	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.print(findDisappearedNumbers(nums));
	}

}
