/********* Time Complexity : O(n) **********/
/********* Space Complexity : O(1) **********/
/********* The code ran in Leetcode **********/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
     
    //base case
     if(nums == null || nums.length==0)
            return new ArrayList<Integer>();
        
        List<Integer> output = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++)
        {
            
            //subtracting 1 from nums[i] since array index starts from 0
            int index = Math.abs(nums[i])-1;
            
            if(nums[index]>0)
                
                //negate existing array element if index value exists
                nums[index] = -nums[index];
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0)
                
                //non negative values are added to the output array
                output.add(i+1);
        }        
        
        return output;   
    
    }
}