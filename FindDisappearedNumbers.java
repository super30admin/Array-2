// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Logic to mutate the array at the index of the current number

// Notes : 

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        
        if( nums == null || nums.length == 0) return list;
                
        for(int i = 0; i < nums.length; i++){
            //check if the number which is to be mutated is already mutated before  
            nums[Math.abs(nums[i]) - 1 ] = nums[Math.abs(nums[i]) - 1 ] < 0 ? nums[Math.abs(nums[i]) - 1 ] : -1 * nums[Math.abs(nums[i]) - 1 ];
        }
        
        for(int i = 0; i < nums.length; i++){
            //numbers which are not mutated, their index+1 are the disappeared numbers
            if(nums[i] > 0){
                list.add(i+1);
            }  
        }
        
        return list;
    }
}
