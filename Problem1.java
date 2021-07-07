//Time Complexity: O(N) or O(2N)
//Space Complexity: 0(1) ; No extra space
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> newList = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -1 *nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                newList.add(i+1);
            }
        }
        return newList;
    }
}