// Time Complexity : O(n) as it is looping through all elements in nums two times
// Space Complexity : O(1) as we are using the same list to store and return
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i + 1);
            }
        }

        return result;
    }
}
