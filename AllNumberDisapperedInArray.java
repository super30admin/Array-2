// Time complexity:- O(n)
// Space complexity:- O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * Approach:
 * This problem is about find all numbers disappered in array and 
 * I iterated through the array to mark each element's corresponding index by converting
 * its value to negative. I used the absolute value of each element to find its corresponding 
 * index and marked that index as visited.After marking, I iterated again to collect all indices 
 * where the values remained positive, indicating that the number corresponding to that index was missing in the array.
 *  
 */ 
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();
        // Marking the elements by making the nuber at index negative
        for(int i = 0; i < nums.length; i++) {
            // Get the index belongs to the number
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                 // Mark this index as seen by making it negative
                nums[index] = nums[index] * -1;
            }
        }

        // adding the only positive numbers which belongs to those indices
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                // The missing number is i + 1
                list.add(i+1);
            }
        }
        //Return the final missing number in arrayList
        return list;
    }
}


