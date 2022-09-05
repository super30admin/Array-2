/*
    Time Complexity - O(n)
    Space Complexity - O(1)
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> output = new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++){
                if(nums[Math.abs(nums[i]) -1] >0){
                    nums[Math.abs(nums[i]) -1] = nums[Math.abs(nums[i]) -1] *(-1);
                 }
            }
        
            for(int i=0;i<nums.length;i++){
                if(nums[i] > 0){
                    output.add(i+1);
                }  
            }
        
            return output;
    }
}
