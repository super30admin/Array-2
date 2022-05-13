// Time Complexity : O(N) where n is the number of elements
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach

public class DisappearArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length; i++){
            if(nums[Math.abs(nums[i])-1] > 0){
                nums[Math.abs(nums[i])-1]*=-1;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length; i++){
            if(nums[i] > 0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
