// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Referenced a solution


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i<n){
           int j = nums[i]-1;
            if(nums[i]!=nums[j]){
                swap(nums,i,j);
            }
            else{
                i++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int k=0;k<n;k++){
            if(nums[k]!=k+1){
                result.add(k+1);
            }
        }
        
        return result;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}