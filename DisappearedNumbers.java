/**
Time complexity: O(n)
Space complexity: O(1)
Execute successfully on Leetcode: Yes
Any problems faced: No
*/

class Solution {
    /**
    Approach:
    - The approach here is to replace the index of the element encountered with a negative number.
    - Eg: nums = [4,3,2,7,8,2,3,1]
      When 4 is encountered, go to index 3 (4-1) and replace the element with its negative i.e make 7 -> -7
    - In the end, the elements that are still > 0 are the numbers that are disappeared.
    */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        
        List<Integer> output = new ArrayList<>();
        
        for(int x: nums) {
            int index = Math.abs(x) - 1;
            
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        
        for(int x = 0; x < nums.length; x++) {
            if(nums[x] > 0) {
                output.add(x+1);
            }
        }
        return output;
    }
}
