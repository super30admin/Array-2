class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int new_index = Math.abs(nums[i])-1;
            if(nums[new_index] > 0){
                nums[new_index] *= -1;
            }
            
              
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }
}