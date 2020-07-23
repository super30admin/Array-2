// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes


// Your code here along with comments explaining your approach
  //since we have number from 1-> len of array.
  //we can think of the numbers as index of array (num[i]-1).
  //mark all number at index(nums[i]-1)  as -ives.
  //on second run if a value at any index is not -ve ,
  //we know we did not see the number.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        //walk over array.
        //mark nums[i] as -ive i's
        for(int i: nums){
            int indx = Math.abs(i) -1;
            if(nums[indx] > 0){
                nums[indx] = -nums[indx];
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                ret.add(i+1);
        }

        return ret;
    }
}
