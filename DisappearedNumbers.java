// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Make the corresponding index of the number negative and find the positive numbers present in the array.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList();
        int n = nums.length;

        for (int i =0;i<n;i++){
            int curNum = Math.abs(nums[i]);
            if(nums[curNum-1]>0)
                nums[curNum-1] *=-1;
        }
            

        for(int i=0;i<n;i++)
            if(nums[i]>0) list.add(i+1);

        return list;
    }
}