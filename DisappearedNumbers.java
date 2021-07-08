//Time Complexity : O(n)
//Space Complexity : O(1)
//Did it run on leetcode:yes


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length ; i++){
            int val = Math.abs(nums[i])-1;
             if(nums[val] > 0)
                 nums[val]*=-1;
        }
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i] > 0 )
                result.add(i+1);  
        }
        return result;
    }
    
}