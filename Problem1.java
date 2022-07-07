//Time Complexity : O(n)
//Space Complexity : O(1), as problem itself requires a List Output.
//Code run successfully on LeetCode.

public class Problem1 {
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
	        
	        if(nums == null|| nums.length == 0)
	            return new ArrayList<>();
	        
	        List<Integer> result = new ArrayList<>();
	        int index;
	        
	        for(int i =0; i < nums.length; i++){
	            
	            index = Math.abs(nums[i]) - 1;
	            if(nums[index] > 0)
	                nums[index] = nums[index] * -1;
	        }
	        
	        for(int i =0; i < nums.length; i++){
	            if(nums[i] > 0)
	                result.add(i+1);
	            else if(nums[i] < 0)
	                nums[i] = nums[i]*-1;
	        }
	        return result;
	    }

}
