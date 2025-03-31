// Time Complexity : O(n)
// Space Complexity : O(1) - for the optimized implementation
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


//findDisappearedNumbers1 - is a brute force implementation using a hash set
//findDisappearedNumbers - is an optimized implementation using inplace subsititution.

class Solution {
    Set<Integer> seen = new HashSet<>();
    List<Integer> result = new ArrayList<>();
    public List<Integer> findDisappearedNumbers1(int[] nums) {

        for (int i=0; i<nums.length; i++){
            seen.add(nums[i]);
        }

        for(int i=1; i<=nums.length; i++){
            if(!seen.contains(i)){
                result.add(i);
            }
        }
        return result;  
    }

        public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index]=-nums[index];
            }            
        }
        

        for(int i=0; i<nums.length;i++){
            if(nums[i]>0)
            result.add(i+1);
        }
        return result;  
    }

}