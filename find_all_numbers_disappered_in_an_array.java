class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i =0; i< n; i++) {
            int value = Math.abs(nums[i])-1;
            if( nums[value]> 0) {
                nums[value] *= -1 ;
            }
        }
        for(int j=0; j<n; j++) {
            if(nums[j] >0) {
                res.add(j+1);
            } else {
                nums[j] *=-1;
            }
        }
        return res;
    }
}