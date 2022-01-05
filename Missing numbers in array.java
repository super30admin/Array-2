//Time complexity: O(n)
//Space complexity:O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            int index= Math.abs(nums[i])-1;
            if(nums[index]>0)
              nums[index] =nums[index]*-1;
        }
        ArrayList<Integer>arr=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                arr.add(i+1);
            }
        }
        return arr;
    }
}