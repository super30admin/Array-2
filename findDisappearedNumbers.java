//Time Complexity: O(n)
//Space Complexity: O(1) Const space
//Leetcode: Success!
//Problems: Switching from Python to java/


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length-1;
       List<Integer> res = new ArrayList<>();
        if(nums==null || nums.length == 0) return res;
        
        for(int i=0; i<=n; i++){
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0){
                nums[idx] *= -1;
            }
            
        }
        for(int i=0; i<=n; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;    
    }
}
