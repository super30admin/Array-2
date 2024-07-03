// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
loop through the array and mark the present number with -ve, at the end index at which positive numbers are present,
those numbers are present.
* */

public class DisappearedNumber {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i< nums.length; i++) {
            int currNum = Math.abs(nums[i]);
            int index = currNum - 1;
            if(nums[index] > 0){
                nums[index]*= -1;
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 0){
                nums[i]*= -1;
            }
            else {
                res.add(i+1);
            }
        }
        return res;
    }

}