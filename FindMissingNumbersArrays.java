/**
 * TC : O(n) SC : O(1)
 * Approach : As the size of the array and the range will be same, there will be some repeating numbers.
 *            negate the number at the value index, repeat it till the last element and at the end only the missing indices numbers will be positive.
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0) return res;
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0){
                nums[idx] *= -1; 
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }else {
                nums[i] *= -1; // to make the array as it was before 
            }
        }
        return res;
    }
}