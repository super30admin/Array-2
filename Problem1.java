class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int n = nums.length;

        for (int i=0; i<n; i++){
            int index = Math.abs(nums[i]) - 1;
            nums[index] = Math.abs(nums[index]) * (-1);
        }
        for (int i=0 ; i<n ; i++){
            if(nums[i] < 0){
                nums[i] = Math.abs(nums[i]);
            }
            else{
                result.add(i+1);
            }
        }
        return result;
    }
}
