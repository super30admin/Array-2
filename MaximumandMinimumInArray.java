//TC - O(n)
//SC - O(1)
import java.util.Arrays;

public class MaximumandMinimumInArray {

	public static void main(String[] args) {
		int[] array = { 4, 3, 2, 7, 8, 2, 1 };
		int[] output = findMaxMin(array);
		System.out.println(Arrays.toString(output));

	}

	private static int[] findMaxMin(int[] array) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 1; i < array.length; i=i+2) {
			if (array[i] > array[i - 1]) {
				max = Math.max(max, array[i]);
				min = Math.min(min, array[i - 1]);
			} else {
				max = Math.max(max, array[i - 1]);
				min = Math.min(min, array[i]);
			}
		}
		
		if (array.length % 2 == 1) { // check last element if its odd
			max = Math.max(max, array[array.length - 1]);
			min = Math.min(min, array[array.length - 1]);
		}
		return new int[] { max, min };
	}

}
