// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Question https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Your code here along with comments explaining your approach
/**
 * Time complexity : O(n) where n is number of elements in array
 * Space complexity : O(n)
 * Did this code successfully run on Leetcode : yes
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      HashMap<Integer,Boolean> map = new HashMap<>();
      // Iterate over array nums and store in map to show its presence by marking as true
      for(int i=0;i<nums.length;++i){
         map.put(nums[i],true);
      }
      List<Integer> result = new ArrayList<>();
      for(int i=1;i<=nums.length;++i){
        // if map does not contain any value from array it means it is not present in array
         if(!map.containsKey(i)){
            result.add(i);
         }
      }
      return result;
    }
}
/**
 * Time complexity : O(n)
 * Space complexity : O(1)
 * Did this code successfully run on Leetcode : yes
 * 
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;++i){
            // converting the values as negative by taking num[i]-1 as index value in same array
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]>0){
              nums[idx] = - nums[idx];
           }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;++i){
            // if any number is not converted into negative it means those are not present
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}