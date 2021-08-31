//Best case occurs when elements are sorted in ascending order, because 
//every time max is less than a[i] and the second condition never gets 
//executed.
//By optimization, we can reduce no of comparison from 2n to 1.5n.
class Pair {
	int min;
	int max;
}
public class Solution {
	public static Pair getMinMax(int arr[], int low, int high) {
		Pair result = new Pair();
		Pair left = new Pair();
		Pair right = new Pair();
		// if there is only one element
		if (low == high) {
			result.max = arr[low];
			result.min = arr[low];
			return result;
		}
		// if there are two elements
		if (high == low + 1) {
			if (arr[low] > arr[high]) {
				result.max = arr[low];
				result.min = arr[high];
			} else {
				result.max = arr[high];
				result.min = arr[low];
			}
			return result;
		}
		// if there are more than 2 elements
		int mid = (low + high) / 2;
		left = getMinMax(arr, low, mid);
		right = getMinMax(arr, mid + 1, high);
		if (left.min < right.min)
			result.min = left.min;
		else
			result.min = right.min;
 
		if (left.max > right.max)
			result.max = left.max;
		else
			result.max = right.max;
 
		return result;
	}
	public static void main(String[] args) {
		int a1[] = { 3, 4, 2, 6, 8, 1, 9, 12, 15, 11 };
		Pair result = getMinMax(a1, 0, a1.length - 1);
		System.out.println("Min: " + result.min);
		System.out.println("Max: " + result.max);
	}
