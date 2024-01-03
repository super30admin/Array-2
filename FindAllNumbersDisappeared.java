// Time Complexity : O(n)
// Space Complexity : O(1)


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int n = nums.length;
        List<Integer> result = new ArrayList();

        for(int i = 0; i < n; i++)
        {
            int x = Math.abs(nums[i]) - 1;
            if(nums[x] > 0) nums[x] *= -1;
        }

        for(int i = 0; i < n; i++)
        {
            if(nums[i] > 0) result.add(i + 1);
        }

        return result;
    }
}