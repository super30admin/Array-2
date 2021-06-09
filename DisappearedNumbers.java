//time complexity:O(n)
//space complexity:O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    
        List<Integer> result=new ArrayList<>();
        if(nums==null||nums.length==0) return result;
        for(int i=0;i<nums.length;i++)
        {
            int index=Math.abs(nums[i])-1;//we take the absolute value as index 
            //cannot be negative. we store the index of the current element
            //[4,3,2,1,6,8]
            //for the current element 4 we store absolute value of 4 -1 i.e. 3
            if(nums[index]>0)
            {
                nums[index]=-1*nums[index];// if the element at the index (3) 
                //is positive we make it negative or vice versa
                
            }
        }
        for (int j=0;j<nums.length;j++)
        {
            if(nums[j]>0)
            {
                result.add(j+1);// if the element(s) are positive
                //then add 1 to the index and add it to the arraylist
            }
        }
        return result;
    }
}
