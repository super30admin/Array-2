// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//In order to keep track of which numbers we have come across, we used the indices of the array
//when we come across a number we go its respective index and change the value to negative
//at the end of this process the spots that are not negative are the ones that are missing



public class FindAllNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List <Integer> result = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return result;
        }

        for(int i = 0; i < nums.length; i++){
            //index
            int idx = Math.abs(nums[i]) - 1;

            //if we have not come to number yet
            if(nums[idx] > 0){
                nums[idx] = nums[idx] * -1;

            }
        }
        //check which ones are not negative
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }

        return result;
    }
}