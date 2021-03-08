// Time Complexity : O(n) for both approaches
// Space Complexity :  O(1) for approach 2 , O(n) for approach 1 for hashset
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
----------------------------------------------------------------------------------Approach 1 --------------------------------------------------------------------
  class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result  = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!hashSet.contains(nums[i])){
                hashSet.add(nums[i]);
            }
        }
        for(int i=1;i<=n;i++){
            if(!hashSet.contains(i)){
                result.add(i);
            }
        }
        
        return result;
    }
}

----------------------------------------------------------------------------------Approach 2---------------------------------------------------------------------------

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //State change apporach
        //TC: O(n), SC: O(1)
        List<Integer> result  = new ArrayList<>();
        if(nums==null || nums.length==0) return result;  
        for(int i=0;i<nums.length;i++){
            if(!(nums[Math.abs(nums[i])-1]<0)){
                nums[Math.abs(nums[i])-1]*=-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}
