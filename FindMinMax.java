/*TC - O (N)
 * SC - O(1)
 *Comparisons  - 1.5*N
 Ran on leetocde - NA, executed on Eclipse IDE
 * */


//Approach - compare in pairs, there would be 3 comparisions for every pair, there are n/2 pais, soe 3* (N/2) comparisons made


import java.util.Arrays;

public class MinMax {
	
	
	public static int[] findMinMax(int[] nums) {
		//int[] ans = new int[2];
		int mini = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 1 ; i < nums.length; i++) {
			if (nums[i] > nums[i-1]) {
				max = Math.max(nums[i], max);
				mini = Math.min(nums[i-1], mini);
			} else {
				max = Math.max(nums[i-1], max);
				mini = Math.min(nums[i], mini);
				
			}
		}
		return new int[] {mini, max};
	}

	public static void main(String[] args) {
		//int[] nums = new int[] {4,5,3,9,2,78,10,12};
		int[] nums = new int[] {4,5,3,9,2,78,1,-1,10,12};
		int [] ans = new int[2];
		ans = findMinMax(nums);
		System.out.println(Arrays.toString(ans));
		
	}
}

/*O/P [-1, 78]
 *
 * */
