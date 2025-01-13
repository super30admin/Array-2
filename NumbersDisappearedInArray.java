import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// while iterating the array , go to the index of the element we are interating and
// multiply by -1 the value at that index. Check how many numbers are above 0 in array and add the index to the result.

public class NumbersDisappearedInArray {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for(int i=0;i<nums.length;i++){
                int index = Math.abs(nums[i]);
                if(nums[Math.abs(index)-1] > 0){
                    nums[Math.abs(index)-1] *= -1;
                }
            }
            List<Integer> result = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if(nums[i] > 0){
                    result.add(i+1);
                }
            }
            return result;
        }
}
