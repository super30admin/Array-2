// TC - O(log n), SC - O(1)

// Find min and max in array in less than 2*(n-1) comparisons, n is length of array
public class FindMinAndMaxInArray {
	public static void main(String[] args) {
		int[] nums = {4, 2, 7, 1, 9, 8, 10};
		// Initializing min and max values
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		// i is used to keep track of first element and second element in pair and j for number of iterations
		// Instead of comparing every value with min and max, in the array we take pairs and compare between them, element which is higher will be compared with max value and element with lower value will be compared to min value
		// In this way, we reduce 1 comparison for every 2 elements and update min and max value accordingly
		int i=0;
		int j=0;
		
		while(j < nums.length/2) {
			int firstEle = i;
			int secEle = i+1;
			i+=2;
			if(nums[firstEle] < nums[secEle]) {
				min = Math.min(nums[firstEle], min);
				max = Math.max(nums[secEle], max);
			}else {
				min = Math.min(nums[secEle], min);
				max = Math.max(nums[firstEle], max);
			}
			j++;
		}
		
		// Above logic will work when array length is even as pairs will sum up to even, when length is odd, an element will be left at back. Compare that value with min and max and update accordingly.
		if(nums.length % 2 == 1) {
			min = Math.min(nums[nums.length - 1], min);
			max = Math.max(nums[nums.length - 1], max);
		}
		
		System.out.println("Minimum element is: "+min+", Maximum element is: "+max);
		
	}
}
