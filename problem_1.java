/**
 * Q. Find All Numbers Disappeared in an Array
 * 
 * Approach 1 - Put all element from input array to set(all elements are unique).
 * Iterate from number 1 to n(length of input array) and check if set contains
 * the number, otherwise add it to result array. Return the result array.
 * 
 * Time Complexity - O(n), two loops both run through length of input i.e O(2N).  
 * Space Complexity - O(n), for storing the hashset and result
 * Runs on Leetcode - Yes
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        HashSet<Integer> numberSet = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        //Add all input numbers to set
        for (int num : nums) {
            numberSet.add(num);
        }
        // Check if input is present in the set, otherwise add to result
        for (int i = 1; i <= nums.length; i++) {
            if (!numberSet.contains(i))
                result.add(i);
        }

        return result;
    }
}

/**
 * Q. Find All Numbers Disappeared in an Array
 * 
 * Approach 2 - Is Based on relationsip of the value and index of the array. If we
 * substract 1 from each item of array then we will get all indexes of array if none 
 * of the numbers are missing(no duplicates). Using this relationship we can mark 
 * all the numbers that are present and then in 2nd loop get all the missing numbers.  
 * 
 * Time Complexity - O(n), two loops both run through length of input.
 * Space Complexity - O(n), for storing the result 
 * Runs on Leetcode - Yes
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        ArrayList<Integer> result = new ArrayList<>();

        //mark all present element by negating them
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0)
                nums[index] = -nums[index];
        }

        //check which number are not marked and add to result
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0)
                result.add(i);
        }

        return result;

    }
}