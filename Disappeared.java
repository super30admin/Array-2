// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<Integer>();
        HashSet<Integer> numbers = new HashSet<>();
        for(int i : nums){
            numbers.add(i);

        }
        for(int i =1;i<=nums.length;i++){
            if(!numbers.contains(i)){
                missingNumbers.add(i);
            }
        }

        return missingNumbers;



    }
}

