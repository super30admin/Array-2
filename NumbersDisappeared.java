import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class NumbersDisappeared {
	
public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int n = nums.length;
        HashSet<Integer> unqSet = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            if(!unqSet.contains(nums[i]))
                unqSet.add(nums[i]);
        }
        
        for(int i = 1; i <= n; i++) {
            if(!unqSet.contains(i)) {
                result.add(i);
            }
        }
        
        return result;
    }

}
