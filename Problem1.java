// 448. Find All Numbers Disappeared in an Array

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return result;
        
        for(int i = 0; i < nums.length; i++)
        {
            int idx = Math.abs(nums[i])-1 ;
            if(nums[idx] > 0)
            nums[idx] = nums[idx] * -1;
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > 0)
                result.add(i+1);
            else 
            nums[i] = nums[i] * -1 ;
        } 
        return result;
    }
}

// Complexity Analysis
/*
Time Complexity : 
O(N)
Space Complexity : 
O(1) since we are reusing the input array itself as a hash table and the space occupied by the output array doesn't count toward the space complexity of the algorithm. 
*/