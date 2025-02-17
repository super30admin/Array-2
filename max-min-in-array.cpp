/*Base Cases:
If the array has only one element, it is both the minimum and maximum.
If the array has two elements, compare them to find the minimum and maximum.
Divide and Conquer:
Recursively find the minimum and maximum of the two halves of the array.
Combine:
Compare the minimums and maximums from the two halves to determine the overall minimum and maximum.

Time Complexity: O(n)
Space Complexity: O(log n) (recursive call stack depth in the worst case)*/
#include<bits/stdc++.h>
using namespace std;
struct Pair {
    int min;
    int max;
};
Pair getMinMax(int arr[], int low, int high) {
    Pair result, left, right;
    int mid;
    if(low==high){
        result.min=arr[low];
        result.max=arr[low];
        return result;
    }
    if(high==low+1){
        if(arr[low]>arr[high]){
            result.max=arr[low];
            result.min=arr[high];
        }else{
            result.min=arr[low];
            result.max=arr[high];
        }
        return result;
    }

    mid=low+high/2;
    left =  getMinMax(arr,  low, mid);
    righ = getMinMax(arr, mid+1, high);
    if(left.min<right.min)
        result.min=left.min;
    else
        result.min=right.min;

    if(left.max>right.max)
        result.max=left.max;
    else
        result.max=right.max;
    return result;
}