// Time complexity: O(N)
// Space complexity: O(N)

// Approach: use a hashmap and add all numbers from the nums array. Now iterate from 1 to N and if any number is missing in the hashmap, add it to the result and return result finally

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }
        
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                result.add(i);
            }
        }
        return result;
    }
}