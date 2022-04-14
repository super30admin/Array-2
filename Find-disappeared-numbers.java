class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums==null || nums.length==0){
            return result;
        }
        for(int i=0;i<nums.length;i++){
            int loc = Math.abs(nums[i]) - 1;
            if(nums[loc] > 0){
                nums[loc] *= -1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                result.add(i + 1);
            }
        }
        return result;
    }
}

//Time Complexity : O(n)
// Space Complexity : O(1)