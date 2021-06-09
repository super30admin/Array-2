// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> finalArr = new ArrayList<>();
        //Base case
        if(nums == null || nums.length == 0) return finalArr;
        for(int num: nums) {
            //If a number exists then make the number-1 index -1 meaning we know it exists
            int index = Math.abs(num)-1;
            if(nums[index]>0) {
                nums[index] *= -1;
            }
        }
        
        //Convvert all the negative numbers back to +ve
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<0)
                nums[i] *= -1;
            else 
                finalArr.add(i+1);
        }
        
        return finalArr;
    }
}
