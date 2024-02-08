//The algorithm finds the disappeared numbers in the range [1, n] in the array nums by marking the presence of each number using the sign of the corresponding index. 
//It then iterates through the modified array to identify the indices with positive values, adding 1 to obtain the disappeared numbers. 
//The time complexity is O(n), where n is the length of the input array nums, and the space complexity is O(1).
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i]) -1;
            if(nums[idx]>0) nums[idx] *= -1;
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0) res.add(i+1);
            else nums[i] *= -1;
        }return res;
        
    }
}