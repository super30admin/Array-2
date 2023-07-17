// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//modify the given array with nagative number(*-1), in the end we return all the negitive numbers with positive index

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int newIndex = 0;
        for(int i=0;i<nums.length;i++){
            newIndex = Math.abs(nums[i])-1;
            if(nums[newIndex] > 0){
            nums[newIndex] *= -1;
            } 
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}