// Time Complexity : O(n) + O(n) for two for loops, where n is the length of the array
// Space Complexity : O(n) where n is the total number of missing elements
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//  for every value v in the array we go to math.abs(v)-1 index and negate it (if negated already skip)which is used as a marker to see if 
// in the second pass we add only the ones which have positive value

// we are doing absolute because the value which a particular index holds might already be negated if that index has been encountered before

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;

            // if the idx is already negated we skip it as it is seen for more than one time
            // and already been negated
            // if not we go to that index and negate it
            if (nums[idx] > 0)
                nums[idx] = -(nums[idx]);

        }

        for (int i = 0; i < nums.length; i++) {
            // if the element is not negated that it means it has not been seen so we add
            // (1+index) to the list
            if (nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }
}

// Similar question leetcode 442
// class Solution {
// public List<Integer> findDuplicates(int[] nums) {

// // edge
// if (nums == null || nums.length == 0) return new ArrayList<>();

// List<Integer> res = new ArrayList<>();

// for (int i=0 ; i<nums.length ; i++){

// int idx = Math.abs(nums[i])-1;

// if (nums[idx]<0){
// res.add(idx+1);
// }else nums[idx] = - nums[idx];
// }

// return res;
// }
// }