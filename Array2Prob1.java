

// Time Complexity : O(n) where n is length of array
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes


// approach : As given range is 1->n, I'll make each element as negative ex, if at index 0 element is 4,then I'll multiply element at index3 as -1. Like that I'll go through all elements and make positive numbers as negative ,then again I'll loop through whole array,which are positive numbers at those indices missing elements are present. 


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        if(nums == null)
            return null;
        
        List<Integer> missings = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int current = Math.abs(nums[i]);
            if(nums[current-1] > 0)
                nums[current-1] *=-1;
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0)
                missings.add(i+1);
        }
        return missings;
    }
}