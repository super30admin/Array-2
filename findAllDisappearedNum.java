import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * First implemented the extra space solution using hashmap and then implemented the solution using O(1) space.
 * In the O(1) space solution, marking the index of the number as negative if the number is present in the array.
 * Then iterating through the array and adding the index of the positive numbers to the result list.
 */

class findAllDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}

/*
 * Extra space solution
 * List<Integer> result = new ArrayList<>();
 * HashMap<Integer,Boolean> map = new HashMap<>();
 * 
 * for(int i=1;i<=nums.length;i++) {
 * map.put(i,false);
 * }
 * 
 * for(int num:nums) {
 * map.put(num,true);
 * }
 * 
 * for(int i=1;i<=nums.length;i++) {
 * if(!map.get(i)) {
 * result.add(i);
 * }
 * }
 * 
 * return result;
 */