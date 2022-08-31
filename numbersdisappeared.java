/*Time Complexity: O(N)
Space Complexity: O(1)*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
         int ni=Math.abs(nums[i])-1;
            if(nums[ni]>0){
                nums[ni]=nums[ni]*-1;
            }
        }
        List<Integer> returning=new ArrayList<Integer>();
         for (int i = 1; i <= nums.length; i++) {
            
            if (nums[i - 1] > 0) {
                returning.add(i);
            }
          }
        return returning;
}
}