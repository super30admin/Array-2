//448. Find All Numbers Disappeared in an Array
//Time Complexity :O(n) as iterating in 1 pass through all n elements
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*Step 1: Take first element in array and subtract 1 from it. Then go to that index particular index number and make the value as negative.
 * Now subtract the 1 from that positive value which just got negated.
 * Step 2: Keep repeating the Step 1 until all possible indexes are covered. At last look at the remaining numbers and take there index and add +1 to it. These numbers are missing numbers.
 */

import java.util.*;

public class dissapeared {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length == 0  || nums == null) return new ArrayList<>();
        
        List<Integer> result=new ArrayList<>();
        
        for(int i=0; i<nums.length; i++)    
        {
            int index=  Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index]=nums[index]*-1;
            }
        }
        
        for(int i=0; i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                result.add(i+1);
            }
        }
        return result;
    }  //O(n), O(1)
	public static void main(String[] args) {
		// nums = [4,3,2,7,8,2,3,1]
		int[] nums= {4,3,2,7,8,2,3,1};
		
		List<Integer> res=new ArrayList<>();
		res=findDisappearedNumbers(nums);
		for(int i: res)
			
		{
			System.out.print(i+" ");
		}

	}

}
