import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

public class FindDisappearedNumber {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            //Base cases
            if(nums == null || nums.length == 0) return new ArrayList<>();

            List<Integer> missingNumber = new ArrayList<>();
            HashSet<Integer> numbers = new HashSet<>();

            //Add 0 - nums.length in hashset
            for (int i: nums) {
                numbers.add(i);
            }

            //Check if i is in hashset else add it to missingnumber linkedlist
            for (int i = 1; i <=nums.length ; i++) {
                if(!numbers.contains(i)){
                    missingNumber.add(i);
                }
            }
            return missingNumber;
        }
    }
}
