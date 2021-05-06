// Time Complexity : O(n) n is the length of the array  
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


//turning the numbers as visited numbers by taking absolute value of every nums[i] and  turning the number in that nums[i]-1 th index as negative.
// In any index if there is a positive number which means, index+1 is the missing number.


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {    
        //Using state change
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int newIndex = Math.abs(nums[i])-1;
            if(nums[newIndex]>0){
                nums[newIndex]*=-1;}
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                result.add(i+1);
        }
        
  
        return result;
        
    }
}