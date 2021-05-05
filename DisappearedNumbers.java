// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through the array linearly
//Space Complexity: O(1) since we are not taking any extra space except result array

public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> returnList = new ArrayList<>();
        
        if(nums == null || nums.length == 0) return returnList;
        
        // Iterate through the array and change the index corresponding to the element to a negative value
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = -1 * nums[index];   
            }
        }
        
        // If there is a positive value then that value + 1 is the element missing
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                returnList.add(i+1);
            }
        }
        
        return returnList;
}