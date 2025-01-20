// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length == 0 || nums == null){
            return new ArrayList<>();
        }
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i =0; i< n; i++){
            // taking index by   substracting -1 from the current element coz if index  will be  1 less  than element
            int index = Math.abs(nums[i]) - 1;
            //if value  at  that index  is positive then make it negative
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
        }
        for(int i  = 0; i<n; i++){
            //Any number in  the  array is positive  which means the   index plus 1  element is missing
            if(nums[i] > 0){
                result.add(i+1);
            }
            else{
                nums[i] = nums[i] * -1;
            }
        }
        return result;
    }
}