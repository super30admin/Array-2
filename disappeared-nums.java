class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null||nums.length==0)
        {
            return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++)
        {
            int neg = Math.abs(nums[i]);
            if(nums[neg-1]>0)
            {
                nums[neg-1] *= -1;
            }            
        }
        
        //returning the index of the elements that are not negated
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                result.add(i+1);
            }
        }
        return result;
        
    }
}

//runtime: O(2n) = O(n)
//space: O(1)
