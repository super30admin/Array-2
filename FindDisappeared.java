import java.util.*;
/*Time Complexity: O(n) only traversing the array once
 * Space Complexity: O(1)
 * Leetcode: yes
 * Any Issues: no
 */
class findDisappeared {
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //I tried to place each number in its actual place by swaping using indexes
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i=0;
        while(i<nums.length)
        {
            int CI = nums[i]-1;
            if(nums[i] != nums[CI] && nums[i] != i+1)
            {
                swap(nums, nums[i]-1, i);
                continue;
            }
            else i++;
           
        }
        for(int k=0; k<nums.length; k++)
        {
            if(nums[k] != k+1)
                result.add(k+1);
        }
        return result;
    }
}