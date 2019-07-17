import java.util.ArrayList;
import java.util.List;

//Appraoch : here key is array index and array values relation is given in problem 1 ≤ a[i] ≤ n .so we will manipulate input array such that value at a[index]=-index
//iterate through whole array and we will calculate result =a[i]-1, also store negative value of result into a[result]. So that we will get all negative values in array except 
//for index where values are disappered. so we will return index+1 and those will be disappered number.

//Time Complexity: O(N) where N number of element in an array

//Space Complexity: O(1) output array is not considered into space complexity

//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this:no

public class FindDisapperedNumber {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
	       List<Integer> result = new ArrayList<Integer>();
	       if(nums==null || nums.length==0) return result;
	       
	       //iterate throught array and substract 1 from each element to get index value and assigning the value =-index  at index 
	       for(int i=0; i<nums.length; i++) {
	           int index = Math.abs(nums[i])-1;
	           if(nums[index]<0) continue;
	           nums[index] = -nums[index];
	       }
	       
	       //all values which are in array will have negative values at those indexes. and index at disappered values will have positive numbers
	       for(int i=0; i<nums.length; i++) {
	           if(nums[i]>0) {
	               result.add(i+1);
	           }
	       }
	       return result;
	   }
	
	public static void main(String[] args) {
		int[] input = {4,3,2,7,8,2,3,1};
		List<Integer> result = new ArrayList<>();
		result = findDisappearedNumbers(input);
		for(int i=0; i<result.size();i++)
		System.out.println("disappered number is"+result.get(i));
		
	}

}
