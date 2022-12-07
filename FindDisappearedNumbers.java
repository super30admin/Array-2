import java.util.ArrayList;
import java.util.List;

//Time Complexity :O(N)
//Space Complexity :O(1) as we are using the same input array and not using any other extra space 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :No 

public class FindDisappearedNumbers {
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
	      List<Integer> result = new ArrayList<>();
	        
	        if(nums ==null || nums.length==0)
	            return result;
	        
	        for(int i=0;i<nums.length;i++){
	            int num = Math.abs(nums[i]);
	             nums[num-1] = -1 *  Math.abs(nums[num-1]);
	            }
	        
	       for(int i=0;i<nums.length;i++){
	           if(nums[i]>0){
	               result.add(i+1);
	           }
	        }
	        
	        return result;
	    }
}
