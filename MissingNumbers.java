public class MissingNumbers {
    // TC is O(n)
    // SC is constant
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(nums[Math.abs(nums[i])-1] > 0){
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}
