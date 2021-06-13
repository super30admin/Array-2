//Time Complexity: O(n)
//Space Complexity: O(1)
// Leetcode 448
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
     int n=nums.length, index=0;
        List<Integer> li=new ArrayList<Integer>();
        // Since we have the array length n..if we find the number in range(1,n), we identify it by the corresponding index. Suppose if we have 1 at index 5, we go to index 1  and make the number at index 1 negative . So, if the number is negative => its index is present in the array.
        for(int i=0;i<n;i++)
        {
            index=Math.abs(nums[i]);
            if(nums[index-1]>0)
            {
               nums[index-1]*=-1;
            }
        }
        
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
                li.add(i+1);
            //To change the input back to its original state
           /* else
                nums[i]*=-1;*/
        }
        return li;
       
    }
}