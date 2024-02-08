//My solution is to return Sum of Min and Max element from the array
// Time Complexity : O(n) [n is length of array]
// Number of comparison: (n/2) * 3 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A, But ran it on Codeninjas [https://www.codingninjas.com/studio/problems/sum-of-max-and-min_1081476?leftPanelTabValue=PROBLEM]
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach

class SumOFMinMaxInArray {
    public static int sumOfMaxMin(int[] arr, int n) {
        // Write your code here.

        // mergeSort(arr, 0, n-1);

        // return arr[0] + arr[n-1];

        // return helperBruteForce(arr, n);

        return helperMinNumberComparison(arr, n);

    }

    private static int helperMinNumberComparison(int[] nums, int n) {
        
        //If only one element I'm return sum of min and max
        if (n == 1) {
            return nums[0] * 2;
        }

        //initalize min and max to first element of array
        int min = nums[0];
        int max = nums[0];


        //Check the ith element is greater the next(ith + 1) element then comapre the greater with Max
        //Make the greate of them as new Max OR the smaller element from ith and ith + 1 will be compared
        //with Min and the smaller among them will be the new Min
        //increment the counter with +2 so that all values are compared in Pairs
        //So evry iteration we only make 3 comparison instead of 4
        for (int i = 0; i < n - 1; i += 2) {
            if (nums[i] < nums[i + 1]) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i + 1]);
            } else {
                min = Math.min(min, nums[i + 1]);
                max = Math.max(max, nums[i]);
            }

        }

        //this is to compare the last elememnt with min and max
        if (nums[n - 1] > max) {
            max = nums[n - 1];
        } else if (nums[n - 1] < min) {
            min = nums[n - 1];
        }

        return min + max;
    }
    // private static int helperBruteForce(int[] nums, int n){
    // int min = nums[0];
    // int max = nums[0];

    // for(int i = 1; i< n; i++) {
    // min = Math.min(min, nums[i]);
    // max = Math.max(max, nums[i]);
    // }

    // return min + max;
    // }

    // private static void mergeSort(int arr[], int left, int right) {
    // if(left < right) {
    // int mid = left + (right -left) / 2;

    // mergeSort(arr, left, mid);

    // mergeSort(arr, mid+1, right);

    // merge(arr, left, mid, right);
    // }

    // }

    // private static void merge(int arr[], int left, int mid, int right) {
    // lengths of sub arrays
    // int nl = mid-left + 1;
    // int nr = right - mid;

    // //create temp leftArr and rightArr

    // int [] leftArr = new int [nl];
    // int [] rightArr = new int [nr];

    // //copy data in to sub array from main array
    // for(int i = 0; i< nl; i++) {
    // leftArr[i] = arr[left + i];
    // }

    // for(int j = 0; j< nr; j++) {
    // rightArr[j] = arr[mid + 1 + j];
    // }

    // //Merge the temp sub arrays in to array

    // //Intialize idxes for sub arrays
    // int i=0, j =0;

    // //intialize indx for merged sub array
    // int k = left;

    // //added values from sub array in to main array from asc order
    // while(i < nl && j < nr) {
    // if(leftArr[i] <= rightArr[j]) {
    // arr[k] = leftArr[i];
    // i++;
    // } else {
    // arr[k] = rightArr[j];
    // j++;
    // }
    // k++;
    // }

    // //add any remaing values from left and right in to main array
    // while(i < nl) {
    // arr[k] = leftArr[i];
    // i++;
    // k++;
    // }

    // while(j < nr) {
    // arr[k] = rightArr[j];
    // k++;
    // j++;
    // }

    // }
}