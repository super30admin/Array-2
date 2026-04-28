// Time Complexity : O(n log n) due to sorting the array
// Space Complexity :   O(1) if we don't consider the output list, otherwise O(n) for the output list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The problem is to find all the numbers in the range [1, n] that are missing from the input array.
// The approach is to first sort the input array and then iterate through the numbers from 1 to n. 
// For each number, we check if it is present in the sorted array. 
// If it is not present, we add it to the result list.
//  We use a pointer j to keep track of our position in the sorted array.
// We compare each number i with the current number at index j in the sorted array.
// If the current number in the sorted array is greater than i, it means i is missing and we add it to the result list.
// If the current number in the sorted array is equal to i, we move the pointer j to the next position in the sorted array to check for the next number. 
// We continue this process until we have checked all numbers from 1 to n.
import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        Arrays.sort(nums);

        int j = 0;

        for (int i = 1; i <= nums.length; i++) {

            if (j >= nums.length || nums[j] > i) {
                result.add(i);
            }

            while (j < nums.length && nums[j] == i) {
                j++;
            }
        }

        return result;
    }
}