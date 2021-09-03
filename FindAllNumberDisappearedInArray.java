// Time Complexity : O(n) single iteration over all elements
// Space Complexity : O(1) no external data structure used for computation
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FindAllNumberDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //null check
        if( nums.length ==0 || nums == null ) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) { //iterating over all elements
            int temp = Math.abs(nums[i]); //taking absolute value in temp
            if(nums[temp-1] > 0) { //safe check if it is positive
                nums[temp-1] = (nums[temp-1] * -1);
                //making num stored at that index negative
            }
            
        }
        
        for( int i = 0; i < nums.length; i++) { //iterating again
            if(nums[i] > 0) result.add(i+1); //wherever positive number encountered
        }
        
        return result;//every found element was turned negative, rest positives are missing
    }
}