// Time Complexity : O(2n) --> O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Since all the numbers are in the range 1 to n in an n-sized array, there will always be an index with number-1. Turn all the numbers at those index negative. Now, find all
 * the index with positive numbers. So, the missing numbers will be index+1.
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int x = Math.abs(nums[i]);
            if(nums[x-1] > 0)
                nums[x-1] *= -1;
        }

        for(int i=0; i<n; i++) {
            if(nums[i] > 0)
                result.add(i+1);
            else
                nums[i] *= -1;
        }

        return result;
    }
}


/*
// Time Complexity : O(2n) --> O(n)
// Space Complexity : O(n)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int x: nums)
            set.add(x);

        for(int i=1; i<=n; i++) {
            if(!set.contains(i))
                result.add(i);
        }

        return result;
    }
}*/
