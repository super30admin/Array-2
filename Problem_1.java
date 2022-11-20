// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//448. Find All Numbers Disappeared in an Array
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                result.add(i + 1);
            }
        }
        return result;
        // HashSet<Integer> set = new HashSet<>();
        // int n = nums.length;
        // for(int i = 1; i < n+1; i++){
        //     set.add(i);
        // }
        // for(int i = 0; i < n; i++){
        //     if(set.contains(nums[i])){
        //         set.remove(nums[i]);
        //     }
        // }
        // return new ArrayList<Integer>(set);
    }
}