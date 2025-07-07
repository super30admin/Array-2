//Time Complexity (TC):** O(n) 
//Space Complexity (SC):** O(1) — no extra space used except the output list.

//Iterate through the array and for each number, mark its corresponding index by negating the value at that index.
//This marking helps identify which numbers have appeared in the array.
//Finally, collect all indices with positive values, as these represent the missing numbers.



class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
}
