//Time Complexity: O(N)
//Space Complexity: O(1)

import java.util.*;
class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList();
        
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            
                int index = Math.abs(nums[i]) - 1;
                if(nums[index] > 0)
                    nums[index] *= -1;

        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > 0)
            {
                res.add(i+1);  
            }
        }
        return res;
    }
}