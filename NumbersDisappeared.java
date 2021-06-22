// The time complexity for both solution is O(n) but for the first one we have used an extra space for Set which is O(n)
// but for the second solution we have used O(1) space
class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> al = new ArrayList<>();
    if (nums.length == 0)
      return al;
    int limit = nums.length;
    Set<Integer> s = new HashSet<Integer>();
    for (int i = 0; i < limit; i++) {
      s.add(nums[i]);
    }
    for (int i = 1; i <= limit; i++) {
      if (!s.contains(i))
        al.add(i);
    }
    return al;
  }
}


class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> al = new ArrayList<>();
    if (nums.length == 0)
      return al;
    for (int i = 0; i < nums.length; i++) {
      int n = Math.abs(nums[i]);
      if (nums[n - 1] > 0)
        nums[n - 1] *= -1;
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0)
        al.add(i + 1);
    }
    return al;
  }
}