// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Use the values of the array to mark the corrosponding indices as seen
The index of the array which is not seen is the missing element
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i=0;i<nums.length;i++){
            int newIndex=Math.abs(nums[i]);

            if(nums[newIndex-1]>0){
                nums[newIndex-1]*=-1;
            }
        }

        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }

        return result;
    }
}