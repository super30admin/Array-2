//Time complexity is O(N)
//Space complexity is O(1)
//Able to submit in leetcode
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int j = Math.abs(nums[i])-1;
            if(nums[j]>0)
                nums[j]=nums[j]*-1;
        }

        List<Integer> result  = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }

        return result;
    }
}