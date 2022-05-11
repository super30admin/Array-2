// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i =0; i<nums.length;i++ ){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]>0){
               nums[idx]*=-1;
            }
        }
        for(int i =0; i<nums.length;i++){
            if(nums[i]<0){
                nums[i]*=-1;
            }else{
             result.add(i+1);
            }
        }
            return result;
        
        
    }
}