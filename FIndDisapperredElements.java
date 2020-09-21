/*
Time Complexity :O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Accepted on Leetcode, Runtime: 6 ms , Memory Usage: 47.5 MB
Any problem you faced while coding this : IMPLEMENTED as discussed in class.
*/
import java.util.*;


class FindDisapperredElements
{
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++)
        {
            int temp = nums[i];
            if(temp < 0) temp *= -1;
            if(nums[temp - 1] > 0) nums[temp - 1] *= -1;
        }
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] > 0) result.add(i+1);
        }
        return result;
    }

    public static void main(String[] args)
    {
        int arr[] = { 4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
    }
}