/*
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison 
*/

//Brute Force
//Time = O(N)
//Space = O(1)

public class MinMaxFinder {

    public static void main(String[] args) {
        int[] arr = {4, 7, 2, 9, 1, 5, 8, 3, 6}; // example array of length 9
        int n = arr.length;

        int min = arr[0]; // initialize min to the first element of the array
        int max = arr[0]; // initialize max to the first element of the array

        for (int i = 1; i < n; i++) { // start the loop from the second element of the array
            if (arr[i] < min) { // if the current element is less than min, update min
                min = arr[i];
            } else if (arr[i] > max) { // if the current element is greater than max, update max
                max = arr[i];
            }
        }

        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}
