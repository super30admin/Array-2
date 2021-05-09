//time- o(n)
//space- o(1)
//passed in leetcode- yes
//issues faced- no

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> res= new ArrayList();
        for(int i=0;i<nums.length;i++)
        {
            int index= Math.abs(nums[i])-1;
            if(nums[index]>0)
            {
                nums[index]*=-1;
            }
            
        }
        for(int i=0;i<nums.length;i++)
        {
        System.out.print(nums[i]);
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                res.add(i+1);
            }
            
        }
        
        return res;
          
    }
}