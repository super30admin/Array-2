// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We can implement in multiple approaches like using extra space HashMap ,HashSet(TC - O(n), SC-O(n)), sort array and check missing numbers (Tc - O(n logn)
// Below using inplace array modification which gives TC - O(n)
class DisappearedNumbersInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i =0;i< n;i++) {
            //
            int num = Math.abs(nums[i]);
            int index = num - 1;

            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        for(int i=0;i< n;i++) {
            if(nums[i] > 0 ) {
                result.add(i+1);
            }
            nums[i] *= -1;
        }
        return result;
    }
}