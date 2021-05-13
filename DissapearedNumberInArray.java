package Array2;

import java.util.ArrayList;
import java.util.List;

/*S30 Big N Problem #31 {Easy}
An integer array is given where 1<= a[i] <=n where n is the size of an array , some elements appear twice and other appear once.

Find all the elements of [1,n[ inclusive that are missing in the array.
try doing it witout using extra space and in o(n) runtime and assume that returned list does not count as extra space

Example:
Input:
[4,3,2,7,8,2,3,1]
Output:
[5,6]
        
Source Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    -------------------------------------------------------------------------------------------------------
    Time complexity : o(n)
    space complexity: o(1) as we are mutating the same array
    Did this code run successfully in leetcode : yes
    problems faces : no
    Since the array has all positive numbers, we can mutate the array like below.
    traverse the array, for each element found at i get nums[i] and got index of nums[i] and change the value to negative. 
    change it to negative only if its positive, already negative numbers need not be changed to positive.
    once the balove process is done for all elements, iterate the array and find indexes which contain positive numbers, so those index numbes are missing in array.
*/
public class DissapearedNumberInArray {
    
    public List<Integer> findDisappearedNumber(int[] nums)
    {
        List<Integer> disapperaedNums = new ArrayList<>();
        if(nums == null || nums.length == 0) return disapperaedNums;
        
        for(int i=0;i<nums.length;i++)
        {
            int idx = Math.abs(nums[i])-1;
            if( nums[idx] >0 )
            {
                nums[idx] *= -1;
            }
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] > 0)
            {
                disapperaedNums.add(i+1);
            }
        }
        
        return disapperaedNums;
     }

}
