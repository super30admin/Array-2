
// Time Complexity : O(n) n is the length of the array  
// Space Complexity : O(1) as we are not considering output array 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


//turning the numbers as visited numbers by taking absolute value of every nums[i] and  turning the number in that nums[1]-i th index negative.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int x= Math.abs(nums[i])-1;
            if(nums[x]>0){
                nums[x]*= -1;
            }
        }
        for(int i =0;i<nums.length;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }return res;
    }
}   