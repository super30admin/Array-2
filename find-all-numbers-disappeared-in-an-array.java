// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //creating a list to store the result
        List<Integer> result = new ArrayList<Integer>();
        //making values negative at the corresponding index  of the value in the array Example: if nums[0] = 4 then make the value at index 4-1 = 3 negative
        for(int i=0; i <nums.length; i++ ){
            //getting the absolute value of the number at the index in case we mark it negative already
            int n = Math.abs(nums[i])-1; 
            //marking the value negative
            if(nums[n] > 0){
             nums[n] *= -1;
            }
        }
        //traversing the array and find the index of the positive values and adding 1  for getting the missing numer to it and adding it to the result
        for(int i=0; i <nums.length; i++){
            if(nums[i] >0){
                result.add(i+1);
            }else{
                nums[i] *= -1;
            }
        }
         return result;
    }
   
}