class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<nums.length+1;i++)
        {
            result.add(i);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(result.contains(nums[i])){result.remove(new Integer(nums[i]));}
        }
        
        return result;
    }
}