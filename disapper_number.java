// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Traverse the array at each number change the value at index-1 element by multiplying with -1 in the first pass, in the second pass traverse the mutated array and then check for positive numbers if you find any positive number just append an empty array result with index where the positive number was found +1


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // null
        if(nums==null || nums.length == 0) return new ArrayList<>();
        List <Integer> result = new ArrayList<>();
        
        //first pass
        for(int i=0; i<nums.length; i++){
            int idx=Math.abs(nums[i])-1;
            if(nums[idx]>0){
                nums[idx] *= -1;
            }
        }
        // second pass
        for(int i=0; i<nums.length; i++){
            if(nums[i] >0){
                result.add(i+1);
            }else{
                nums[i]*=-1;
            }
        }
        return result;
    }
}