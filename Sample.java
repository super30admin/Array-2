Problem1
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Time limit exceeded
// Any problem you faced while coding this :  


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            l.add(i+1);
        }
        for(int i=0;i<nums.length;i++){
            if(l.contains(nums[i])){
                int pos = l.indexOf(nums[i]);
                l.remove(pos);                
            }
        }
        return l;
    }
}
