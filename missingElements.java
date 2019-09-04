class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> out=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int temp = Math.abs(nums[i])-1;
            if(nums[temp]>0){
                nums[temp]=nums[temp]*(-1);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                out.add(i+1);
            }
        }
        return out;
    }
}