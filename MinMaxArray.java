/*
Author: Akhilesh Borgaonkar
Problem: Given an array of numbers of length N, find both the minimum and maximum. (in less than 2 * (N - 2) comparisons) (Array-2)
Approach: To reduce the number of comparisons in the array, I am using pair of integers. I compare and find the minimum in the pair and
    then compare it with global minimum. I find the maximum in the pair and then comapre it with the global maximum. This brings down the
    number of comparisons to 2(N-2) - (2 for global min-max comparison and (N-2) for doing it in pairs)
Time Complexity: O(n) where n is number of elements in input array
Space complexity: O(1) constant
verified on IDE.
*/

public class MinAndMax {
    public static void main(String[] args) {
        int[] arr = new int[] {2,4,1,5,11,7,0,6};
        int n = arr.length;
        int min = arr[0], max = arr[0];

        for(int i=0; i<n; i++){
            if(i == n-1){
                if(min > arr[i])
                    min = arr[i];
                if(max < arr[i])
                    max = arr[i];
            }
            else {
                if(arr[i] > arr[i+1]){
                    if(max < arr[i])
                        max = arr[i];
                    if(min > arr[i+1])
                        min = arr[i+1];
                } else {
                    if(min > arr[i])
                        min = arr[i];
                    if(max < arr[i+1])
                        max = arr[i+1];
                }
            }
        }

        System.out.println("min: " + min + " max: " + max);
    }
}