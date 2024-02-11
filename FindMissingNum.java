// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Three line explanation of solution in plain english : in order to avoid extra space, make in place changes to mark the presence of the number and find indexes unchanged.

// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < nums.length ; i++){
            int idx = Math.abs(nums[i]) - 1; // the index where the num should be stored if it is sorted and unique.
            if(nums[idx] > 0){
                nums[idx] *= -1; // make it negative to mark the presence of the number
            }
        }

        
        for(int i = 0 ; i < nums.length ; i++){
            // find number which remained positive, as their index+1 is the values missing
            if(nums[i] > 0 ){
                res.add(i + 1);
            }
            else{ // to keep the original state as same
                nums[i] *= -1;
            }
        }

        return res;
    }
}