/** Time Complexity: O(n) where n is the number of elements in array
 * Space Complexity: O(1)
 * Executed on Leetcode: yes
 * approach :
 * we iterate through the array, we check if the number present at the index = Math.abs(nums[i]-1) is marked negative or not, if not,we mark that number negative
 * we iterate the array once again and return the indices of the elements which are still positive.
 */
import java.util.*;
class findNumbers
{
    public List<Integer> findmissing(int[] nums)
    {   List<Integer> list = new LinkedList<>();
        if(nums.length==0) return list;
        for(int i=0;i<nums.length;++i)
        {
            int checkIndex = Math.abs(nums[i])-1;
            if(nums[checkIndex]>0) nums[checkIndex] *= -1;
        }
        for(int i=0;i<nums.length;++i)
        {
            if(nums[i]>0) list.add(i+1);
        }
        return list;
    }
    public static void main(String[] args) {
        findNumbers obj = new findNumbers();
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println("missing numbers:"+obj.findmissing(nums));
    }
}