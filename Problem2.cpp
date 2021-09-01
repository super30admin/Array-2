
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes(not leetcode, gfg question)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

#include <bits/stdc++.h>
using namespace std;
 

 // create a minmax pair
struct Pair{
    int min;
    int max;
};

struct Pair getMinMax(int arr[], int n)
{
    struct Pair minmax;
    int i;
    // if the array size is 0, return -1
    if(n == 0){
        minmax.min = -1;
        minmax.max = -1;
        return minmax;
    }

    // if only 1 element in the array return the element as both
    if(n == 1){
        minmax.min = arr[0];
        minmax.max = arr[0];
        return minmax;
    }

    // if the array has even number of elements, make the 1st and 2nd element of array  as min max
    if(n%2 == 0){
        if(arr[0] > arr[1]){  
            minmax.min = arr[1];
            minmax.max = arr[0];
        }
        else{
            minmax.min = arr[0];
            minmax.max = arr[1];
        }
        i = 2;
    }

    // if the array has odd number of elements set both the min & max as the first element
    else{     
        minmax.min = arr[0];
        minmax.max = arr[0];
        i=1;
        
    } // compare pair of elements
    while(i<n-1){
        if(arr[i] > arr[i+1]){
            
            minmax.min = min(arr[i+1], minmax.min);
            minmax.max = max(arr[i], minmax.max);
        }
        else{
            minmax.min = min(arr[i], minmax.min);
            minmax.max = max(arr[i+1], minmax.max);
        }
        i +=2;
    }
    return minmax;  // return the minmax pair
    
}

// int main()
// {
//    return 0;
// }