class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int val : nums){
            int idx = Math.abs(val) - 1;
            if(nums[idx] > 0){
                // we mark the element as negative
                nums[idx] = nums[idx] * (-1);
            }
        }
        // find the positive element, then add the index + 1 to the result 
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }
}