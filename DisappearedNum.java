// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
Changing the values of the element at index where index  = (value - 1). By this method, 
we change all the elements to -ve except the missing element index. 
Then iterate again to retrieve the missing element i.e. +ve element index + 1.
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length ==0||nums==null) return result;
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0)
                nums[index] *= -1;
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j] > 0) result.add(j+1);
        }
        return result;
    }
}
