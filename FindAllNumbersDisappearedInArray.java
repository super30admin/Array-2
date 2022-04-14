// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
/*

Since there are elements ranging from 1 to n, 
we iterate through every element and mark the num[element] as negative.
we do the same for all 
The indices  that have positive elements are the elements that are missing


*/


import java.util.*;
public class FindAllNumbersDisappearedInArray{

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length==0)
        {
            return new ArrayList<>(); 
        }
        List<Integer> list = new ArrayList<>();
        
        for(int i =0;i<nums.length;i++)
        {
            int currentVal = Math.abs(nums[i]-0);
            
            if(nums[currentVal-1]>0)
            {
                nums[currentVal-1] = -nums[currentVal-1];
            }
        }
        
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                list.add(i+1);
            }
        }
        
        return list;
    }

    public static void main(String args[])
    {
        int arr[] = {4,3,2,7,8,2,3,1};
        List<Integer> ans = findDisappearedNumbers(arr);
        for(int i:ans)
        {
            System.out.print(i+" ");
        }
    }
}