// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : The space complexity is O(1) since we are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> output = new LinkedList<>();

        for(int i=0;i<nums.length;i++){

            int num = Math.abs(nums[i])-1;

            // If an number is visited, change the value in that index to negative.
            if(nums[num] > 0){
                nums[num] = nums[num]*-1;
            }
        }

        for(int i=0;i<nums.length;i++){

            // Positive number represents that the value is never encountered which is the missing value
            if(nums[i] > 0){
                output.add(i+1);
            }
        }

        return output;

    }
}