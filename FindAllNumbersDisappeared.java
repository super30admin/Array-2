class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1] > 0)
                nums[Math.abs(nums[i])-1] *= -1;
        }
        List<Integer> ret = new ArrayList<>();

        for(int i=0;i<nums.length;i++)
            if(nums[i]>0)
                ret.add(i+1);
        return ret;
    }
}