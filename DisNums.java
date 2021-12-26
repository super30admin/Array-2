// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
public class DisNums {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length ; i++){
            int index = Math.abs(nums[i]) -1 ; 
            if(nums[index] > 0){
                nums[index] = -1 * nums[index];
            }
        }
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] < 0){
                nums[i] = -1 * nums[i];
            }
            else{
                result.add(i + 1);
            }
        }
        return result; 
    }
}
