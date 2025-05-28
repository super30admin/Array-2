//Time Complexity = O(n)
//Space Complexity = O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resList = new ArrayList<>();
        for(int i =0 ; i<nums.length; i++){
            int temp = Math.abs(nums[i]);
            if(nums[temp-1] > 0){
                nums[temp-1] = -nums[temp-1];
            }
        }
        for(int j=0; j<nums.length; j++){
            if(nums[j] > 0){
                resList.add(j+1);
            }
        }
        return resList;
    }
}