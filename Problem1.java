// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int no=Math.abs(nums[i]);
            int idx=no-1;                   //getting the actual position of the number
            if(nums[idx]>0)
                nums[idx]=nums[idx]*-1;   //making the number negative to mark it as found
        }
        for(int i=0;i<nums.length;i++){  
            if(nums[i]>0)                  //if the number is positive, it means that the number i+1 was not found
                ans.add(i+1);
        }
        return ans;
    }
}