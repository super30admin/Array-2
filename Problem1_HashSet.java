/**
LeetCode Submitted : YES
Space Complexity : O(N)
Time Complexity : O(N)

Idea is to take HashSet and store the numbers encountered
**/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> output  = new ArrayList<>();
        
        Set<Integer> in = new HashSet<>();
        
        //Boundary Case
        if(nums == null || nums.length <1)
            return output;
        
        //Processing 
        for(int i =0; i< nums.length; i++){
            in.add(nums[i]);
        }
        
        //check
        for(int i =1; i<= nums.length; i++){
            if(!in.contains(i))
                output.add(i);
        }
        
        return output;
        
        
    }
}
