// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem2 Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

// Example 2: Array with Even length of Elements
// Sample Input : int[] arr = {12, 20, 4, 5, 100, 2, 3, 49, 500, 99};
// Sample Output : Min : 2, Max : 500

// Example 2: Array with Odd length of Elements
// Sample Input : int[] arr = {12, 20, 4, 5, 100, 2, 3, 49, 500, 99, 1};
// Sample Output : Min : 1, Max : 500

class Main {
    public static void main(String[] args) {

        int[] arr = {12, 20, 4, 5, 100, 2, 3, 49, 500, 99, 1};

        // Initializing min & max
        int min = Integer.MAX_VALUE; 
        int max = Integer.MIN_VALUE;

        // Iterating through the array in pairs
        for (int i = 0; i < arr.length - 1; i += 2){
            if(arr[i] > arr[i+1]){ // Comparing pairs and checking accordingly
                max = Math.max(max, arr[i]); // Comparing larger element with max
                min = Math.min(min, arr[i+1]); // Comparing smaller element with min
            }
            else{
                max = Math.max(max, arr[i+1]); // Comparing larger element with max
                min = Math.min(min, arr[i]); // Comparing smaller element with min
            }
        }

        // Handling the last element if the array length is odd
        if (arr.length % 2 != 0){
            max = Math.max(max, arr[arr.length - 1]);
            min = Math.min(min, arr[arr.length - 1]);
        }

        // Printing the results to the console
        System.out.println("Min : " + min);
        System.out.println("Max : " + max);
    }
}