//time complexity: O(n)
//space complexity: O(1)
//Did it run successfully on leetcode: YES

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        for(int i=0; i<nums.length; i++) {
            int temp;
            temp = Math.abs(nums[i]) - 1;
            if(nums[temp] > 0){
                nums[temp] = nums[temp] * -1;
            }
        }
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}