// Time Complexity :o(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:Here i used array to store the missing element. I iterate through the array and substract by 1 to get the index and then make it as - and so on. then positive numbers would be added to the array. 


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++){
            int idx = Math.abs(nums[i]) - 1;

            if (nums[idx] > 0){
                nums[idx] = -nums[idx];
            }
        }

        for (int i = 0; i < n; i++){
            if (nums[i] > 0){
                result.add(i + 1);
            }
        }

        return result;
    }
}
