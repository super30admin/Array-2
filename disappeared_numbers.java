// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<>();
        int size = nums.length;
        
        for(int i =0; i<size; i++){
            int index = Math.abs(nums[i])- 1;
            
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
            
        }        
        for(int i =0; i<size; i++){
            if(nums[i] > 0)
                output.add(i+1);
        } 
        return output;
    }
}

/*
// Time Complexity : O(N) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<>();
        int size = nums.length;
        
        boolean[] array = new boolean[size];
        for(int i =0; i<size; i++){
            if(!array[nums[i]-1])
                array[nums[i]-1] = true;
        }        
        for(int i =0; i<size; i++){
            if(!array[i])
                output.add(i+1);
        } 
        return output;
    }
}
*/