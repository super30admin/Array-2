// Time Complexity :O(n)
// Space Complexity :O(1); since using same input array for evaluation.
// Did this code successfully run on Leetcode : yes
/* Here, we have altered the same array that was passed as an input by multiplying visited
element by -1 to make it negative. If we once again get to revisit the element we will just ignore.
To decide which element to visit we are subtracting each element in the input array from 1.
We can now decide the missing element by finding the positive elements at the particular index.
for example, if index obtained is 8 it means that the element 9 is missing (9 if present would give 9-1=8
and we would have multiplied the element at 8 by -1)*/


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l=new ArrayList<Integer>();
        if(nums==null||nums.length==0)
            return new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int p=Math.abs(nums[i])-1;
            if(nums[p]>0)
            nums[p]=(-1)*nums[p];
        }
         for(int i=0;i<n;i++){
             if(nums[i]>0)
                 l.add(i+1);
         }
        return l;
    }
}