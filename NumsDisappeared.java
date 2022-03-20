// Time Complexity : O(n) , n is length of input
// Space Complexity : O(1) . result space in not extra space
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> answer = new ArrayList();

        for(int i=0; i<nums.length; i++)
        {
            if(nums[Math.abs(nums[i])-1] > 0)
                nums[Math.abs(nums[i])-1] *= -1;
        }

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] > 0)
                answer.add(i+1);
        }

        return answer;

    }
}
