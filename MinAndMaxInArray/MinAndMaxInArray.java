/* Time Complexity : O(n)
 * 	n - length of the input array - arr */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

class MinAndMaxInArray{
	
	public void minAndMaxInArray(int[] arr){
		if(arr == null || arr.length == 0) return;
		
		int n = arr.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int index = 0;
		
		//odd length
		if(n%2 != 0){
			min = arr[0];
			max = arr[0];
			index = 1;
		}
		
		for(int i = index; i < n - 1; i+=2){
			if(arr[i] < arr[i+1]){
				min = Math.min(arr[i], min);
				max = Math.max(arr[i+1], max);
			}else{
				min = Math.min(arr[i+1], min);
				max = Math.max(arr[i], max);
			}
		}
		
		System.out.println("Mininum number : " + min);
		System.out.println("Maximum number : " + max);
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 5, 4, 1, 9};
		MinAndMaxInArray obj = new MinAndMaxInArray();
		obj.minAndMaxInArray(arr);
	}
 	
}
