class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums==null || nums.length ==0){
            return result;
        }
        
        for(int i=0;i<nums.length;i++){
            
            int index = Math.abs(nums[i])-1;
            if(nums[index] >0){
                nums[index] = -1 * nums[index];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                nums[i] = -1 * nums[i];
            }
            else{
                result.add(i+1);
            }
        }
        return result;
    }
}