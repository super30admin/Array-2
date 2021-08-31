// Time Complexity: O(n) as we are traversing the array 2 times only
// Space Complexity: O(n) an additional set is used
// Did you complete the code on leet code: Yes
// Any problems faced: instead of using nums.length to check missing, used set.size which gave wrong output.

// Write your explaination here
// Idea here it to remove all the duplicates and perform a value search in constant time
// Hashset provided a way to do both stored all the values in a set and iterating upto the length of array to fing which index+1 value is not present in set.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        for(int i=0; i<nums.length; i++) {
            if(!set.contains(i+1)) {
                result.add(i+1);
            }
        }
        return result;
    }
}