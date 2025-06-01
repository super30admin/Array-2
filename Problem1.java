//Problem: Find-all-numbers-disappeared-in-an-array
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            int temp = nums[i];

            if(temp <0){
                temp *= -1;
            }

            if(nums[temp-1] <= n){
                if(nums[temp-1] > 0){
                    nums[temp -1] *= -1;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }

        return result;
    }
}