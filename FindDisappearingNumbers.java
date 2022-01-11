// Time Complexity : O(n) where n is the length of the given nums array
// Space Complexity : O(1) as the list created is the one we are returning
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : thought of hashing solution first
// then updated according to the approach dicussed in the class


// Your code here along with comments explaining your approach


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }

        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                res.add(i+1);
        }

        return res;
    }
}
