//TC=O(n)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for(int index = 0; index < nums.length; index++){
            int p = nums[index];
            int i= Math.abs(p)-1;
            if(nums[i]>0){
                nums[i]=-nums[i];
            }
        }
        // Here instead of creating p we can write for(int p : nums)
        for (int index=0; index<nums.length; index++){
            if(nums[index]>0){
                result.add(index+1);
            }
        }
        return result;
    }
}