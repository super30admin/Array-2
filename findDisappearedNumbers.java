// TC : O(N)
// SC : O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int index = 0;
        List<Integer> res = new ArrayList<>();
        for(int i: nums){
            index = Math.abs(i)-1;
            if(nums[index] > -1){
                nums[index] *= -1;
            }
        }
        
        for(int i=0; i< nums.length; i++){
            if(nums[i] > -1){
                res.add(i+1);
            }
            else{
                nums[i] *= -1;
            }
        }
        return res;
        
    }
    
}
