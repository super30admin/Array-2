class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            set.add(nums[i]); // add all the elements to has set
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) { //check whether set contains the nu,ber or not
                result.add(i);
            }
        }
        return result;
    }
}

Time complexity : O(n)
space complexity: O(n)