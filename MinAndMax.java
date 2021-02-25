/*
 * Time: 
 * T(n)  = 3n/2 -2
 */

package Super30;

public class MinAndMax {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1000, 11, 445, 1, 330, 3000, 30001};
        int[] result = minAndMax(arr, 0, arr.length - 1);
        System.out.printf("\nMinimum element is %d", result[0]);
        System.out.printf("\nMaximum element is %d", result[1]);
	}

	private static int[] minAndMax(int[] nums, int low, int high) {
		int[] minmax = new int[] {-1, -1};
		int[] minmaxL = new int[] {-1, -1};
		int[] minmaxR = new int[] {-1, -1};
		
	
		//if only one element
		if(low == high) {
			minmax[0] = nums[low];
			minmax[1] = nums[low];
			return minmax;
		}
			
		//if only two element
		if(high == low+1) {
			if(nums[low] < nums[high]) {
				minmax[0] = nums[low];
				minmax[1] = nums[high];
				return minmax;
			}
			else {
				minmax[0] = nums[high];
				minmax[1] = nums[low];
				return minmax;
			}
		}
		
		//for more than 2 elements
		int mid = low + (high - low)/2;
		
		minmaxL = minAndMax(nums, low, mid);
		minmaxR = minAndMax(nums, mid+1, high);
		
		//compare min of these two
		if(minmaxL[0] < minmaxR[0])
			minmax[0] = minmaxL[0];
		else
			minmax[0] = minmaxR[0];
		
		
		if(minmaxL[1] > minmaxR[1])
			minmax[1] = minmaxL[1];
		else
			minmax[1] = minmaxR[1];
		
		return minmax;
	}
}
