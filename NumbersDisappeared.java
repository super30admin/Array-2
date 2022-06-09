import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        //cretae a list of integers to return at the end
        List<Integer> result = new ArrayList<>();
        
        //if the nums array is empty then return the empty result
        if (nums == null) return result;
        
        int n = nums.length;
        
        //looping through each element of the array
        //
        for (int i = 0; i < n; i++) {
            
            //here we will find the index of elements if they were sorted non-decreasing
            //this is a clever way to get the sorted indices without actually sorting
            int idx = Math.abs(nums[i]) - 1;
            //[4,3,2,6,1,4]
            //for the first element, idx = 3
            //calculating the idx [4(3), 3(2), 2(1), 6(5), 1(0), 4(3)]
            
            
            //if the value at the sorted index is non-negative then we turn it negaitve
            //this way we will make all the elements at the sorted indexes negatice
            //leaving the elements positive at sorted index of elements that do not actually exists
            //for the first iteration, nums[idx] will be nums[3] is 6>0
            if(nums[idx] > 0) 
            {
                
                nums[idx] = nums[idx] * -1;
                //nums[3] is now -6
                //this means 3+1 = 4 exists in the array
            }
        }
        
        //looping through each element of the array one more time 
        for (int i = 0; i < n; i++) {
            
            //now, if the there are elements in the nums array that are still positive
            //we know that the indices of those ones+1 are the elements missing in the array
            if(nums[i] > 0)
            {
                //adding the elements which are non negative to result
                //these are the elements that did not exist in nums and thus were not converted to negative
                result.add(i+1);
            }
            else
            {
                //if the elements are negative then multiplying with -1
                //to restore the state of the original nums array
                nums[i] = nums[i] * -1;
            } 
        }
        //returning the array with the numbers not existing in the nums array
        return result; 
    }
}