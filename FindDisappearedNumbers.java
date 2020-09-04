// Time Complexity : o(n) n is the length of the array n+n computations
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Visit all the numbers in the array and for each number visited, negate the value in the number-1 index
//At the end, wherever there are positive numbers in the array, that index+1 would be the missing number 


class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length ==0){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        //Visit all the numbers in the array and for each number visited, negate the value in the number-1 index
        for(int i=0;i<nums.length;i++){
            int k = Math.abs(nums[i]); //taking the absolute as the value might be negated for the index corresponding to another number in the array
            if(nums[k-1]>0){//Don't want to do anything if we have already negated for that index
                nums[k-1] = -1* nums[k-1];
            }
        }
        
        for(int i=0;i<nums.length; i++){
            //At the end, wherever there are positive numbers in the array, that index+1 would be the missing number 
            if(nums[i]>0){ 
                result.add(i+1);
            }
        }
        return result;
    }
}