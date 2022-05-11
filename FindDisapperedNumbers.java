// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
}