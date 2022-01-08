//Time Complexity: O(n)
//Space Complexity:O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            int tempIndex = Math.abs(nums[i]) - 1;
            if(nums[tempIndex]>0){
                nums[tempIndex] = nums[tempIndex] * -1;                
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}