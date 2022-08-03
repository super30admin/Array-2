// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //ArrayList to store the missing Elements
        List<Integer> result = new ArrayList<>();
        
        //First Pass, make negative  
        for(int i=0;  i<nums.length; i++){
            //For Array, take the corresponding index => element-1
            int idx = Math.abs(nums[i])-1;

            //If its not negative, change its state to negative
            if(nums[idx] > 0){
                nums[idx] = nums[idx] * -1;
            }
        }
        //Second Pass, Find Missing and make all postive
        for(int  i=0;  i<nums.length; i++){
            //If its not negative, add to result ArrayList
            if(nums[i] >0){
                result.add(i+1);
            }
            //If its negative, change its state to positive, we will get our  actual Array
            else{
                nums[i]  *=  -1;
            }
        }    
        return result;   
    }
}





