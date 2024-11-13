//448. Find all numbers disappeared in an Array - https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
//Time Complexity: O(n)
//Space Complexity: O(1) - mutating the same array by changing state of the numbers

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length==0)
            return new ArrayList<Integer>();

        List<Integer> output = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] > 0) {
                //only if positive number
                nums[idx] = -nums[idx]; //mark numbers as visited by adding "-"
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                output.add(i+1);
            } else {
                nums[i] *= -1; //to retrieve input array back
            }
        }
        return output;
    }
}