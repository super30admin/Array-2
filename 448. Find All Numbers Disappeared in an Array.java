// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // //Approach1 TC: O(n) SC: O(n)
        HashSet<Integer> hs =  new HashSet<>();
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length==0) return result;
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        for(int i=1;i<=nums.length;i++){
            if(!hs.contains(i)){
                result.add(i);
            }
        }
        return result;
        
        
       // Approach2 TC: O(n) SC: O(1)
//         List<Integer> res = new ArrayList<>();
//         if(nums == null || nums.length == 0) return res;
//         for(int i=0;i<nums.length;i++){
//             if(nums[Math.abs(nums[i])-1]>=0){
//                 nums[Math.abs(nums[i])-1] *= -1;
//             }
//         }
    
        
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]>0){
//                 res.add(i+1);
//             }
//         }
//         return res;        
        
        //Approach3
//         int[] result = new int[nums.length];
//         List<Integer> res = new ArrayList<>();
//         if(nums == null || nums.length == 0) return res;
//         for(int i=0;i<nums.length;i++){
//             result[nums[i]-1] = 1;
//         }
        
//         for(int i=0;i<nums.length;i++){
//             if(result[i]==0){
//                 res.add(i+1);
//             }
//         }
//         return res;
    }
}