// Time Complexity : O(n)
// Space Complexity : O(n) for the output array where we are storing the elements and n is the no. of elements in the input array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            int n = Math.abs(nums[i])-1;
            if(nums[n]>0)
                nums[n]*=-1;
            
        }
        
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            
            if(n>0)
                result.add(i+1);
        }
        
        return result;
    }
}