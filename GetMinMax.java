// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
//taking array elements in pairs to reduce the total comparison to 2*(n-2)

class Solution {
     public static void main(String[] args){
        int[] arr = {-4,3,2,7,-8,14};
		int max = arr[0], min = arr[0];
		for(int i=0; i<arr.length; i=i+2){
			//to escape indexout of bounds
			if(i == arr.length-1){//if array contains odd elements and we are at the last element
				min = Math.min(min,arr[i]);
				max = Math.max(max,arr[i]);
			}
			else if(arr[i] < arr[i+1]){
				min = Math.min(min,arr[i]);
				max = Math.max(max,arr[i+1]);
			}
			else if(arr[i] > arr[i+1]){
				min = Math.min(min,arr[i+1]);
				max = Math.max(max,arr[i]);
			}
		}
		System.out.println("max" + " "+ min);
    }
}