// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length==0)
            return new LinkedList<Integer>();

        List<Integer> result = new LinkedList<>();

        for(int num : nums){
            int idx = Math.abs(num)-1;
            if(nums[idx]>0)
                nums[idx] = -1 * nums[idx]; //multiply by -1 to mark existence
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                result.add(i+1);
        }

        return result;
    }
}