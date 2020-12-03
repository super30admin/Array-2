// Time Complexity :O(N) n are the number of elements in the given array.
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach: Traversing the array and negating the index of the element value. So again traversing,
// we will be able to find all the positive elements whose index values are the disappeared numbers.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result= new ArrayList<>();
        if(nums==null||nums.length==0){
            return result;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]>0)
                nums[Math.abs(nums[i])-1]*=-1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                result.add(i+1);
        }
        return result;
        
    }
}