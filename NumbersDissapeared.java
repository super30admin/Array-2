class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        //O(n) time and O(1) space
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -1 * nums[index];
            }

        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = -1 * nums[i];
            } else {
                list.add(i + 1);
            }

        }

        return list;

    }
}