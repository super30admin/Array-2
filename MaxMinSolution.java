// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not Sure
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
// 2*(N-1) Comparisions happen only when the array is sorted in decreasing order[5,4,3,2,1,0];

public class MaxMinSolution {
	
	public int[] maxMinElemets(int[] A) {
		if(A == null || A.length == 0) return new int[]{};
		int n = A.length;
		int max = A[0];
		int min = A[0];
		for(int i = 1 ; i < n; i++) {	
			if(max < A[i]) {//N-1 Comparisions
				max = A[i];
			}else if(min > A[i]) {//Worst case N-1 Comparisions
				min = A[i];
			}
		}
		return new int[] {min,max};
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new MaxMinSolution().maxMinElemets(new int[]{})));

	}

}