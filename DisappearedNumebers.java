/*
    Leetcode problem 448: Find all numbers disappeared in an Array
    T.C: O(n) :: S.C: O(1) - Expected to return a List of Integers

    Solved by marking the (current value - 1) -> index as negative
    Note: that the current value can be repeated, so if we have already
    marked the indexed value as negative we do nothing and if current
    value is negative (i.e. it has been marked negative and is being iterated
    for the first time) we take its absolute value. Go over the array again
    and return the positive value's index + 1 in an ArrayList.
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int temp = Math.abs(nums[i]) - 1;
        /*
            if (nums[i] > 0) {
                temp = nums[i] - 1;                
            } else {
                temp = (nums[i] * -1) - 1;
            }
        */
            if (nums[temp] > 0) {
                nums[temp] *= -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            } else {
                nums[i] = Math.abs(nums[i]); 
            }
        }

        return result;
    }
}