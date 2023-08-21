// TC : O(n)
// SC: O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i]) -1;

            if(nums[idx] > 0){
                //positive
                nums[idx] *= -1;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                //gets the number that is missing
                result.add(i+1);
            }
            else{
                // convert the array back to positive
                nums[i] *= -1;
            }
        }
        return result;
    }
}