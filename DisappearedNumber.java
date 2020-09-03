//Time Complexity- O(n)
//Space Complexity=O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null||
          nums.length==0)
        {
            return new ArrayList();
        }
        List<Integer>list=new ArrayList();
        for(int number: nums)
        {
            int i=Math.abs(number)-1;
            if(nums[i]>0)
            {
                nums[i]*=-1;       
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                list.add(i+1);
            }
            
        }
         
        return list;
    }
}