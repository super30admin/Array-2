//Method 1: With Extra Space
// Time Complexity :O(N)+O(N)~O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Yes


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        TC:O(N)+O(N)
        SC:O(N)
         List<Integer> result=new ArrayList<>();
         if(nums.length==0||nums==null) return result;
          Set<Integer> dup=new HashSet<>();
           for(int i=0;i<nums.length;i++){
               dup.add(nums[i]);
           }
         for(int i=0;i<nums.length;i++){
             if(!dup.contains(i+1)) result.add(i+1);
         }
         return result;
    }
}

//Method 2: With No Extra Space
// Time Complexity :O(N)+O(N)~O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Yes


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //TC:O(N)+O(N)(2 passes)
        //SC:O(1)
        List<Integer> result=new ArrayList<>();
        if(nums.length==0||nums==null) return result;
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]<0) continue;
            else nums[Math.abs(nums[i])-1]=-nums[Math.abs(nums[i])-1];

        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) result.add(i+1);
        }
        return result;
    }
}