// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Make the element at the index of the found number negative. In the end return the index+1 of any remaining positive number
class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i =0 ; i < nums.length ; i++){
            int id = Math.abs(nums[i]) - 1;
            if(nums[id]>0){
                nums[id]*=-1;
            }
        }
        for (int i =0 ; i < nums.length ; i++){
            if(nums[i]>0){
                result.add(i+1);
            }else{
                nums[i] *=-1;
            }
        }
        return result;
    }
}