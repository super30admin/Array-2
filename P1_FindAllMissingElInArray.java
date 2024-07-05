/*
 TC: O(n)
 SC: O(1)
 Did this code successfully run on Leetcode :yes
 Approach: 
 Loop through all the elements and mark the cirresponding number as negetive
 at the end all the positive number's index + 1 are the numbers that are missing

 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<nums.length; i++) {
            int currNum = Math.abs(nums[i]);
            int index = currNum - 1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i]<0) {
                nums[i] *= -1;
            } else {
                list.add(i+1);
            }
        }
        return list;
    }
}