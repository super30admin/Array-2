import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time Complexity : O(n)
//Space Complexity :O(1) constant space.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//implemented the logic where the we mark the items present as -1 at their correspondin indices location.
//after first pass, iterate the nums array again whose item value is >0  then it is missing , add it to list and return the list.

//binary search for missing element if the array is in sorted , i.e. O(log n)
//Consider the array is sorted.
//[1,2,2,3,3,4,7,8]
//we have the binary search funtion , we run the loop from 1 to n, pass the index as target and find if it is present in the array or not. 
//if it not present , add it to res list and retrun.



//Bitwise XOR for missing element if the array is in not sorted  , i.e. dont know.

public class findMissingArray {


	public static void main(String[] args) {

		Solution s = new Solution();
		int[] arr = {4,3,2,7,8,2,3,1};
		System.out.print(s.findDisappearedNumbers(arr));
		
		
		int[] arr1 = {4,5,2,2,2,2,3,1};
		System.out.print(s.findDisappearedNumbersWithBinarySearch(arr1));

	}
	static class Solution {
		public List<Integer> findDisappearedNumbers(int[] nums) {


			List<Integer> res = new ArrayList<>();

			for(int i=0;i<nums.length;i++){

				int temp = nums[i];

				if(temp<0) { 
					temp *= -1; // make the -ve number to +ve again;
				}
				if(nums[temp-1]>0) { 
					nums[temp-1] *= -1;  // make the items -ve where the temp-1 th value.
				}
			}

			for(int i=0;i<nums.length;i++){

				if(nums[i]>0) {
					res.add(i+1);
				}   
			}
			return res;
		}

		public List<Integer> findDisappearedNumbersWithBinarySearch(int[] arr1) {

			List<Integer> res1 = new ArrayList<>();
			Arrays.sort(arr1);
			for(int i=1;i<=arr1.length;i++){
				if(binarySearch(arr1,i) == -1){
					res1.add(i);
				}
			} 
			return res1;
		}
	}
	
	public static int binarySearch(int[] nums, int target) {
	    if (nums == null || nums.length == 0) {
	        return -1;
	    }
	    
	    /*.*/
	    int left = 0, right = nums.length - 1;
	    //when we use the condition "left <= right", we do not need to determine if nums[left] == target
	    //in outside of loop, because the jumping condition is left > right, we will have the determination
	    //condition if(target == nums[mid]) inside of loop
	    while (left <= right) {
	        //left bias
	        int mid = left + (right - left) / 2;
	        if (target == nums[mid]) {
	            return mid;
	        }
	        //if left part is monotonically increasing, or the pivot point is on the right part
	        if (nums[left] <= nums[mid]) {
	            //must use "<=" at here since we need to make sure target is in the left part,
	            //then safely drop the right part
	            if (nums[left] <= target && target < nums[mid]) {
	                right = mid - 1;
	            }
	            else {
	                //right bias
	                left = mid + 1;
	            }
	        }

	        //if right part is monotonically increasing, or the pivot point is on the left part
	        else {
	            //must use "<=" at here since we need to make sure target is in the right part,
	            //then safely drop the left part
	            if (nums[mid] < target && target <= nums[right]) {
	                left = mid + 1;
	            }
	            else {
	                right = mid - 1;
	            }
	        }
	    }
	    return -1;
	}
	
	

}
