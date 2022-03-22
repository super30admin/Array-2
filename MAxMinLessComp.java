// Time Complexity : O(n) n is number of elements in array
// Space Complexity : O(1)
// Any problem you faced while coding this : no

/*
if we do linear search, we compare each num with max and min so number of comparisons = 2*n
to significantly reduce the number of comparisons, we look at nums array in form of pairs, in each pair the nums are compared
then larger is compared with current max and smaller with current min. So we have 3 comparisons per pair and there are n/2 pairs
so number of comparisons = (1.5)*n
*/

public class MAxMinLessComp
{
  public static int[] solve(int[] nums)
  {
    int n = nums.length;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for(int i=0; i<nums.length-1; i++)
    {
      if(nums[i] > nums[i+1])
      {
        max = Math.max(max, nums[i]);
        min = Math.min(min, nums[i+1]);
      }
      else
      {
        max = Math.max(max, nums[i+1]);
        min = Math.min(min, nums[i]);
      }
    }

    return new int[]{max, min};
  }
  public static void main (String ar[])
  {
    int[] nums = {4,1,-1,-2,3,9,7};
    int[] result = solve(nums);
    System.out.println(result[0]+" "+result[1]);
  }
}
