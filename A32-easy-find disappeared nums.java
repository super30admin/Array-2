//TC: O(n)
//SC: O(1)


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List <Integer> result= new ArrayList<>();
        int n= nums.length;
        // System.out.print(Math.abs(-44));
        for(int i=0;i<n;i++)
        {
            int idx= Math.abs(nums[i])-1;
            if(nums[idx]>0)
            {
                nums[idx]*= -1;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]<0)
                nums[i]*= -1;
            else
                result.add(i+1);
        }
        return result;
    }
}