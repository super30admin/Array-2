// In this problem, we should find the numbers that do not appear in the given nums array
// The number that are supposed to appear are : 1 to n where n is the length of the array
// In this solution, we will be iterating and modifying the given array to find the missing numbers.
// TC: O(n) - two pass solution in which we are iterating over the whole array twice - once to mark as visited and next to find missing number
// SC: O(1) - if we do not consider the space of the result otherwise, in worst case O(n) 

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int index = 0;
        // First pass to mark number as visited
        for(int i=0;i<nums.length;i++){
            index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] = nums[index] * (-1);
            }
        }
        // Second pass - we find numbers that are not marked as visited which means the index does not exist
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}
