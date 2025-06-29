/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time complexity - O(N)
Space Complexity - O(1)
 */

import java.util.ArrayList;
import java.util.List;
public class FindAllNumbersDisappearedInArray_LC448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;   // Get the original value even if it was negated,  Convert value to 0-based index
            if (nums[index] > 0) {               // If not already marked
                nums[index] = -nums[index];      // Mark it negative
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                output.add(i + 1);
            }
        }
        return output;
    }
}
/*
Brute force TC - O(N) + O(N) SC - O(N)+O(N)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> output = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            hs.add(nums[i]);
        }
        for(int i= 1; i<=nums.length;i++){
            if(!hs.contains(i)){
                output.add(i);
            }
        }
     return output;
    }
}
 */