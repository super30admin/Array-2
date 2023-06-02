class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<Integer>();
        List<Integer>result = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int abs = Math.abs(nums[i]);
            if(nums[abs - 1] > 0){
                nums[abs - 1] *= -1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i]<0){
                nums[i] *= -1;
            }else{
                result.add(i + 1);
            }
        }
        return result;
    }
}
