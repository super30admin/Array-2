Leetcode 448. Find All Numbers Disappeared in an Array
//Time complexity : O(n+n) //n is length of nums
//Space Comlexity: O(1) // As list is returned as a result
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums== null ){
            return new ArrayList<>();
        }
        List<Integer> ls = new ArrayList<>();
        for(int i=0 ; i<nums.length; i++){
            int n = nums[i];
            n= Math.abs(n);
            if(nums[n-1]>0){
                nums[n-1]=-1*nums[n-1];
            }
            
        }
        for(int i=0 ; i<nums.length; i++){
            if(nums[i]>0){
                ls.add(i+1);
            }
        }
        return ls;
    }
}