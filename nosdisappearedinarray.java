//time complexity:o(n)
//space complexity: o(1)
//run on leetcode yes
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        for (int i : nums) {
            int index = Math.abs(i); //taking the Absolute value bcoz if the values are repeated in the array negative multiplied by negatuve becomes positive and our logic wont work
            if (nums[index - 1] > 0) {
                nums[index - 1] = nums[index - 1]*-1; // multiplying the existing number index with  -1 to make it negative
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { //checking for numbers with positive values and adding it to our list
                result.add(i + 1);
            }
        }
        return result;
    }
        
    }