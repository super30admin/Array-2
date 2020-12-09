/** Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
* Find all the elements of [1, n] inclusive that do not appear in this array.
*
*TC O(N). Space complexity O(1)
* Code was submitted on leetcode
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappear = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return disappear;
       for (int i = 0; i< nums.length; i++) {
           int index = Math.abs(nums[i])-1;
           if (nums[index] > 0) {
                nums[index] = -1 * nums[index];
               }           
        }
        for (int i = 0; i< nums.length; i++) {
           if (nums[i] > 0) {
                disappear.add(i+1);
            }           
        }
        return disappear;
    }
}
