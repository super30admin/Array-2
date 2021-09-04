time complexity: O(n)
space complexity: O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>(); //creating a result list
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1; //getting the absolute value
            if (nums[val] > 0) { //making the value if >0 to -nums[val]
                nums[val] = -nums[val];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { 
                result.add(i + 1); //adding it to the result list
            }
        }
        return result; //return result
    }
}