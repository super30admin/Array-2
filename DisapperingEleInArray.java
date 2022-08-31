class Solution {
    //tc-o(n)
    //sc-o(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
       
        List<Integer>result = new ArrayList<>();
         if(nums==null||nums.length==0) return result;
        int n = nums.length;
        //make all the ele present negative at its index
        for(int i=0;i<n;i++)
        {    
         
         int index = Math.abs(nums[i])-1;   
           if(nums[index] >0)//not negitive
            {
                nums[index]*= -1;
            }               
            
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
            {
                result.add(i+1);
            }
            else
            {
                nums[i]*=-1;
            }
        }
        
        return result;
    }
}