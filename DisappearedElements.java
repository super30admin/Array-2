// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class DisappearedElements {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 0) {
                nums[i] *= -1;
            } else {
                output.add(i+1);
            }
        }
        return output;
    }
}