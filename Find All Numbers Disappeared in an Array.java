// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i=0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) nums[idx] *= -1;
        }
        // System.out.println(Arrays.toString(nums));
        for (int i=0; i < nums.length; i++){
            if (nums[i] > 0) result.add(i+1);
        }
        return result;
    }
}