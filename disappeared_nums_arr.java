class Solution {
    /*
    Time complexity: O(n)
    Space complexity: O(1)
    */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        // check if the nums array is empty or not
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        
        List<Integer> output = new ArrayList<>();
        
        // traversing nums
        for(int x : nums){
            // index is value x - 1
            int index = Math.abs(x) - 1;
            
            // if the nums value at index is positive then
            if(nums[index] > 0){
                // update it as negative so that the same value is not updated again
                nums[index] *= -1;
            }
        }
        
        // traverse the nums again
        for(int x = 0; x < nums.length; x++){
            // if the values are positive then
            if(nums[x] > 0){
                // add x + 1 to the output list as those are the missing elements
                output.add(x + 1);
            }
        }
        // return the list
        return output;
    }
}