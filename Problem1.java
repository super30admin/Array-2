// Time Complexity : O(N)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes

//Problem statement: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<Integer>();
        for(int i:nums){

            int index = Math.abs(i) - 1;
            if(nums[index] > 0){
                nums[index] = -nums[index];
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                res.add(i+1);
            }else{ 
                nums[i] *= -1;
            }
        }

        return res;
    }
}