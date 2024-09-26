/**
 * LeetCode Execution: No Problem
 */

/**
 *  Solution 1 - Swapping 
 */ 

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1); One extra variable is used, but one can write to swao two numbers without extra variable.
 */
class Solution {
  public List<Integer> findDisappearedNumbers(int[] a) {
      List<Integer> l = new ArrayList<>();
      for(int i = 0; i < a.length; i++) {
          while(a[i] != i + 1 && a[a[i]-1] != a[i]) { 
              int t = a[a[i]-1];
              a[a[i]-1] = a[i];
              a[i] = t;
          }
      }
      
      for(int i = 0; i < a.length; i++) if(a[i] != i + 1) l.add(i + 1);
      return l;
  }
}

/**
 *  Solution 2 - Sign Manipulation (Most Intutive & I guess can be used in other cases when we need to mark some elemenst ot stuff.)
 */ 

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
     List<Integer> result = new ArrayList<Integer>();
     
     for(int i = 0; i < nums.length; i++) {
       // Pass One Change Sign of values whose Indexes are found in the array
         int val = Math.abs(nums[i]) - 1;
         if(nums[val] > 0) nums[val] = -nums[val];
     }
     // Indexes with positive values are missing indexes.
     for(int i = 0; i < nums.length; i++) {
         if(nums[i] > 0) result.add(i+1);
     }
     return result;
 }
}

 /**
 *  Solution 3 - Inspired From Hasing (Cool Solution)
 *  Problem: To consider Over Flow when adding "n"
 */ 

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1) 
 */

public List<Integer> findDisappearedNumbers(int[] nums) {
  List<Integer> res = new ArrayList<>();
  int n = nums.length;
  for (int i = 0; i < nums.length; i ++) nums[(nums[i]-1) % n] += n;
  for (int i = 0; i < nums.length; i ++) if (nums[i] <= n) res.add(i+1);
  return res;
}