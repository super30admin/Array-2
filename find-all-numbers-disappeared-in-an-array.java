// Time Complexity :
O(2n) ==> O(n)  traversing the nums array twice
// Space Complexity :
o(1) 
// Did this code successfully run on Leetcode :
yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>();
        //Iterate through the nums array
        for(int i=0;i<nums.length;i++){
        
    //To handle the case when input has already been modified and to get the original number
            int val=Math.abs(nums[i])-1;
           
            if(nums[val]>0)
                nums[val] = -1 * nums[val];
        }
        
        /*Iterate through the modified input array to find if there are any positive elements
        in the nums array
        */
        for(int j=0;j<nums.length;j++){
            if(nums[j]>0){
                result.add(j+1);
            }
        }
        return result;
    }
}