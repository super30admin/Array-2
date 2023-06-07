// Time Complexity o(n) space complexity o(1);
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]>0){
                nums[idx]*=-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] >0){
                missing.add(i+1);
                
            }
            else{
                nums[i]*=-1;
            }
        }
        return missing;
    }
}
