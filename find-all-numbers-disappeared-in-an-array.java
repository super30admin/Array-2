// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english :  For each number in the array, mark its corresponding index as negative to indicate it exists. 
// After marking, any index that remains positive represents a number that is missing. Collect all such missing numbers and return them.



class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++) {
            int idx = Math.abs(nums[i]) -1;
            if(nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        for (int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                output.add(i+1);
            }

        }
        return output;
    }
}