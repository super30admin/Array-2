// Used a count array to store the elements at appropriate positions, and then iterate over count array to identify missing
// TC: O(n)
// SC: O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        int i, n;
        n = nums.length;
        int[] count = new int[n + 1];
        for(i = 0; i < n; i++) {
            count[nums[i]] = nums[i];
        }
        for(i = 1; i <= n; i++) {
            if(count[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}