//TC: O(n)

//SC: O(1)

// Approach: Make use of Indices and make it negative. 


class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    for(int i: nums) {
      int idx = Math.abs(i);
      if(nums[idx-1] > 0) {
        nums[idx-1] *= -1;
      }
    }
    List<Integer> res = new ArrayList<>();
    for(int i=0; i<nums.length; i++) {
      if(nums[i] > 0)
        res.add(i+1);
    }
    return res;
  }
}