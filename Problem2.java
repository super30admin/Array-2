//Time Complexity O(3N/2) where N is the number of elements
//Space Complexity O(1) since we are not using any extra space
// Since we have to solve the problem in less than O(2N-2) time complexity. The solution to traverse through the array and check one by one for each element comparing it with max and min will be 2N solution. The below solution solves the problem in 3N/2 because I am pairing the elements and making one comparision with each other. second comparison will be min with the minimum between the pair, third comparision will be between max and the maximum element between the pair. So for 2 elements we make total of 3 comparisions. So for N elements it becomes 1.5N Time complexity. 

public static void main(String args[]) {
		int[] arr = { -8,3,2,7,-4,14};
		int min = arr[0]; // Initialize the min with the first element
		int max = arr[0]; // Initialize the max with the first element
		for(int i=1;i<arr.length;i+=2) {      // Increment the for by 2
			if(i==arr.length-1) {         // This is for the remaining element '14' in the example, which will not have a pair element
				min=Math.min(min,arr[i]);
				max = Math.max(max, arr[i]);
			}
			else if(arr[i] <arr[i+1]) {    // Compare the 2 elements in the pair if the ith element is smaller than i+1th min will be ith
				min=Math.min(min,arr[i]);
				max = Math.max(max, arr[i+1]);
			}
			else if(arr[i] > arr[i+1]) {    // Compare the 2 elements in the pair if the ith element is greater than i+1th max will be ith
				min=Math.min(min,arr[i+1]);
				max = Math.max(max, arr[i]);
			}
			
		}
		System.out.println("Max "+max);
		System.out.println("Min "+min);
	}
