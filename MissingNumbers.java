// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//brute force solution using a set

class Solution {
    class Solution {
     public List<Integer> findDisappearedNumbers(int[] nums){
        int missingNumbers;
        HashSet set = new HashSet();
        List<Integer> ans = new ArrayList<>();
        int counter=0;
        for (int i=0; i<nums.length;i++){
            set.add(nums[i]);
        }
        missingNumbers = nums.length-set.size();
        for (int i=1; i<=nums.length;i++){
            if (counter==missingNumbers){
                break;
            }
            if (!set.contains(i)){
                ans.add(i);
                counter++;
            }
        }
        return ans;
    }
}
}