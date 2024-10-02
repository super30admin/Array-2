class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]>0) nums[Math.abs(nums[i])-1]*=-1;
        }
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) li.add(i+1);
        }
        return li;
    }
}
