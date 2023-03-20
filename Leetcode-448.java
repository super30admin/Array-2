// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
 
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int idx = nums[i];
            if(idx<0){
                idx = -idx;
            }
            if(nums[idx-1]>0){
                int temp = nums[idx-1];
                nums[idx-1] = -temp;
            }
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]>0){
                output.add(j+1);
            }
            else{
                int temp = nums[j];
                nums[j] = -temp;
            }
        }
        return output;
    }
}