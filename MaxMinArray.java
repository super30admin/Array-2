/*
 * Time Complexity - O(N) where N is the length of the input array.
 * Space Complexity - O(1)
 */
public class getMaxnMin {	
	
	public static void main(String[] args) {		
		int[] arr = {4, 7, 1, 0, -2, 8, 6, 5};		
		printMaxnMinInArray(arr);		
	}

	private static void printMaxnMinInArray(int[] arr) {		
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		
		System.out.println(max);
		System.out.println(min);		
	}
}
