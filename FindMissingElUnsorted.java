// TIME: O(n)
// SPACE: O(n)
// SUCCESS on LeetCode

public class FindMissingElUnsorted {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        
        List<Integer> answers = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(nums[i])) {
                int count = numsMap.get(nums[i]) + 1;
                numsMap.put(nums[i], count);
            } else {
                numsMap.put(nums[i], 1);
            }
        }
        
        for (int i = 1; i <= nums.length; i++) {
            if (!numsMap.containsKey(i)) {
                answers.add(i);
            }
        }
        
        return answers;
    }
}
