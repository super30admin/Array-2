// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class DisappearedNumbersInArray {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int val = Math.abs(nums[i]);

                if(nums[val - 1] > 0){
                    nums[val - 1] *= -1;
                }
            }

            for(int i = 0; i < n; i++){
                if(nums[i] < 0){
                    nums[i] *= -1;
                }
                else{
                    list.add(i + 1);
                }
            }

            return list;
        }
    }
}
