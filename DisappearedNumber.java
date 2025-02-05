// Time Complexity : O(n) where n = number of elements in array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        //elements in array should be from 1 to n, if nums[i]=4 mark index 4 as -1
        for(int i = 0; i < n; i++) {

            int index = Math.abs(nums[i]) - 1;

            //marking the index as visited
            //if any element is negative then it means that index is present in array
           if(nums[index] > 0) {
                nums[index] *= -1;
           }
           
        }

        //index which is positive will be stored in result
        for(int i = 0; i < n; i++) {

            //The index is negative because that index is present in array, if it was positive then it would not be negative
            if(nums[i] > 0) {
                result.add(i + 1);
            }
            else {
                nums[i] *= -1;
            }
        }
        
        return result;
    }
}
