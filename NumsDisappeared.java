// Time Complexity : O(n) , n is length of input
// Space Complexity : O(1) . result space in not extra space
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english :
/*
In order to record that a number (num) exists in input array, we go to (num-1)th index and make it negative (if not already negative)
Then we traverse the array again and look for positive values. Suppose i index has positive values, missing number is i+1
*/

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
