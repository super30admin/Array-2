// Time Complexity : amortized O(N).
                    //he worst case would be something like this - [7,2,2,3,4,5,6] 
                    //where would stay at index 0 and do n-1 comparisons/swaps and 
                    //then one comparison/wap at every other index. 
                    //So worst case would be O(2N) and 
                    //hence the complexity of the algorithm would be amortized O(N). 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Nope

import java.util.*;

public class MissingElementInArray{
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        
        List<Integer> missing = new ArrayList<>();
        
        //start at index 0
        int x = 0;
        while(x < nums.length) {
            int num = nums[x];
            
            if(num == -1 || num-1 == x) {
                //if number is -1 or if its at the correct location - do nothing
                x++;
            } else if(nums[num-1] == num) {
                //if our current num is repeating element, put -1 at current index
                nums[x] = -1;
                x++;
            } else {
                //else we need to put current number at its correct position
                //hence swap it but stay at current index
                nums[x] = nums[num-1];
                nums[num - 1] = num;
            }
        }
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == -1) {
                missing.add(i + 1);
            }
        }
        
        return missing;
    }
}