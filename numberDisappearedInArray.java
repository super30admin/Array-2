/*
Time complexity : O(n)
Space complexity: O(1)
*/
class numberDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        //null check
        if(nums == null || nums.length == 0) return result;
        //make negative of the value in the index for each value
        for(int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        //find the missing numbers
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i+1);
            } else {
                nums[i] *= -1;
            }
        }
        return result;
    }
}