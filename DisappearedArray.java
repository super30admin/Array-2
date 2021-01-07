// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Forgot condition if(nums[tmp] > 0) only then do -ve

class DisappearedArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return list;

        for(int i=0;i<nums.length;i++){
            int tmp = Math.abs(nums[i]) - 1;
            if(nums[tmp] > 0)
                nums[tmp] = nums[tmp] * -1;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }

        return list;
    }
}