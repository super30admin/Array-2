// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
//Use a HashSet to track which numbers appear.
//Iterate from 1 to n, and collect numbers that don't appear in nums.
//Return those missing numbers.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        for(int i: nums) h.add(i);
        for(int i=1;i<=nums.length;i++) {
            if(!h.contains(i)) l.add(i);
        }
        return l;
    }
}
// Your code here along with comments explaining your approach
