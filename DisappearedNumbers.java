/*
 * Time Complexity : O(m*n)
 * Space Complexity :  O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - As we iterate through the array and for every element to go to the element's index and mulitply the element by -1.
 * If the element is already negative then we ignore it. This way we can single out all the element which were not visited by finding the indices with positive numbers.
 */

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/895550534/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]>0)
                nums[Math.abs(nums[i])-1]=-1*nums[Math.abs(nums[i])-1];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}