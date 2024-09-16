//time complexity: O(n)
//space complexity:O(1)

import java.util.*; 

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        List<Integer> res = new ArrayList<>();
        while(i < nums.length)
        {
            if (nums[i] != nums[nums[i]-1])
                swap(nums, i, nums[i]-1); 
            else
                i++;   
        }
        
        for (int j = 0; j < nums.length; j++)
        {
            if (nums[j] != j+1)
            {
                res.add(j+1);
            }
        }
        return res;
    }
    public static void swap(int[] nums, int i, int j)
    {
        int val = nums[i];
        nums[i] = nums[j];
        nums[j] = val;
        
    }
}