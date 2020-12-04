// Time Complexity : O(N), N-> number of elements in the input array
// Space Complexity : O(1), since no additional space is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



public class NumbersDisappeared{
	
    //function to check whether the number is negative
	public boolean isNegative(int n) {
		return (n<0);
	}
	
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	
    	List<Integer> result = new ArrayList<Integer>();
        
        //base case: checking whether the input array is empty or not
    	if(nums==null || nums.length==0) {
    		return result;
    	}
    	
        //finding the index by subtracting the element by 1 and multiplying the element at that particular index by -1 if it's not negative already.
    	for(int i=0;i<nums.length;i++)
    	{    		
    		int index = Math.abs(nums[i])-1;
    		if(!isNegative(nums[index])) {
    			nums[index] = nums[index]*-1;
    		}
    	}
    	//a loop to count the number of positive integers in the array, storing their indices into list after incrementing by 1
    	for(int i=0;i<nums.length;i++) {
    		if(!isNegative(nums[i])) {
    			result.add(i+1);
    		}
    	}
    	return result;
    }
	public static void main(String[] args) {
		NumbersDisappeared ob = new NumbersDisappeared();
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(ob.findDisappearedNumbers(nums));
	}
}