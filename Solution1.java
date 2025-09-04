// Find All Numbers Disappeared in an Array
// Ran on leetcode: Yes
// TC: O(n) SC:O(1)
/* 
Iterate through array and take the value at each index and reduce it by one. Use the value as index and make the value at that index to negative. Loop through the array again and the result are the index which dont have negative values.
*/
class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int numsLen = nums.length;

        for(int i = 0; i < numsLen; i++){

            // Get the index and mark it as negative
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0){
                nums[idx] *= -1;
            }
        }

        for(int i = 0; i < numsLen; i++){
            // Add the index which still have positive values
            if(nums[i] > 0){
                result.add(i + 1);
            }
        }

        return result;
    }
}