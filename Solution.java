// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Ues
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class Solution {
    public int minimumDeletions(int[] nums) {
        int max = -999999;
        int min = 999999;
        int n = nums.length;
        int idxMin=0; int idxMax=0;

        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1]){
                min=Math.min(min,nums[i]);
                max=Math.max(max,nums[i+1]);
            }else{
                min=Math.min(min,nums[i+1]);
                max=Math.max(max,nums[i]);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==min){
                idxMin = i;
            }if(nums[i]==max){
                idxMax = i;
            }
        }

        int front = Math.max(idxMin+1,idxMax+1);
        int back = Math.max(n-idxMin,n-idxMax);
        int both = Math.min(idxMin+1,n-idxMin)+
         Math.min(idxMax+1,n-idxMax);

        int ans= Math.min(front,Math.min(back,both));

        return ans;
    }
} 
