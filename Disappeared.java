//Time Complexity: O(n)
//Space complexity: O(1)
//Executed on leet code.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList<Integer>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {    
            if(nums[Math.abs(nums[i])-1]>0)             //If a number is available chaning respective index to negative of same number. So the number which is positive indicates the repective index is missing.
                nums[Math.abs(nums[i])-1] = 0-nums[Math.abs(nums[i])-1];
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)                           //if at a particular index a positive number is found, add the respective index to the list.
                list.add(i+1);
            else
            {
                nums[i] = 0- nums[i];
            }
        }
        return list;
    }
}