// S30 Big N Problem #30 {Easy}
// 448. Find All Numbers Disappeared in an Array
// Time Complexity : O(n) {2 parse}
// Space Complexity : No extra space
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
// Dry run
//  0 1 2 3 4 5 6 7
// [4,3,2,7,8,2,3,1]
//  0  1  2   3 4 5 6 7
// [-4,-3,-2,-7,8,2,-3,-1]
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>();
        //Edge case
        if(nums==null || nums.length==0) return result;
        //Logic
        //Make negatives
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1; //index starts from 0
            if(nums[index]>0){
                nums[index] *=-1;
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1); //index starts from 0
            }
        }
        return result;
    }
}