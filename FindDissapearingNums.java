class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        ArrayList<Integer> list = new ArrayList();
        for(int num: nums){
            //4 1 2 3 -2 4 5
            if(num<0)   {
                int modNum = -1*num;
                if(nums[modNum-1]>0) 
                nums[modNum-1] = -1* nums[modNum-1];
                //num=-4 nums[3] = -1*nums[3]
                
            }
            else{
                //num =1 --> nums[0] = -1*1
                if(nums[num-1]>0)
                nums[num-1] = -1* nums[num-1];
            }
        }
        for(int i = 0; i< nums.length; i++)  {
            if(nums[i]>0)   {
                list.add(i+1);
            }
        }
        return list;
    }
}