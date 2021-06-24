// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
// Created a list of size of nums then went over the nums and at the index of the value changed it from 0 to 1 in list of result
// Then went over result list and if the value was 0 then added the value to results arraylist

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int size = nums.length;
        int [] result = new int[size];
        for(int i = 0; i < size; i++){
            result[nums[i]-1] = 1;
        }
        
        List<Integer> results = new ArrayList<>();
        for(int j = 0; j < size; j++){
            if(result[j] == 0){
                results.add(j+1);
            }
        }
        
        return results;        
        
    }
}
