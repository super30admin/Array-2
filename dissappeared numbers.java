// Time Complexity :o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : initially array index out ou bounds.


// Your code here along with comments explaining your approach: for every number in the array changing sign of value present at number-1 place and checking which values are positive and returning indices+1;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> List = new ArrayList<Integer>(); 
        for(int i=0;i<nums.length;i++){
            int p = Math.abs(nums[i]);
            if(nums[p-1]>0){
            nums[p-1]=0-nums[p-1];
                }
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]>0){
                List.add(j+1);
            }
        }
        
        
        
    return List;}
}