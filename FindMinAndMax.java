// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class FindMinAndMax {
	public static int[] getMinMax(int[] nums) {
		int[] result=new int[2];
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]>nums[i+1]) {
				max=Math.max(max, nums[i]);
				min=Math.min(min, nums[i+1]);
			}else {
				max=Math.max(max, nums[i+1]);
				min=Math.min(min, nums[i]);
			}
		}
		
		result[0]=min;
		result[1]=max;
		return result;
	}
	
	public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        int[] minmax = getMinMax(arr);
        System.out.printf("\nMinimum element is %d", minmax[0]);
        System.out.printf("\nMaximum element is %d", minmax[1]);
 
    }
}
