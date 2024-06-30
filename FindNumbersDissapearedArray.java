// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    boolean[] check = new boolean[nums.length+1];
    List<Integer> result = new ArrayList<>();
    // Using a boolean array to to update to true if that index exists
    for(int num: nums) {
      check[num]=true;
    }
    // Looping through the array. When comes across false, add that index to result.
    for(int i = 1; i<check.length; i++) {
      if(check[i]==false) result.add(i);
    }
    return result;
  }
}