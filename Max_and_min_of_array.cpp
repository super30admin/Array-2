// Apporach 1 and Approach 2
// Time Complexity : O(n)  ... n is number of elements in given array           
// Space Complexity : O(1)   ..... hasmap is used to store data 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Geek For Geeks : https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

Maximum and minimum of an array using minimum number of comparisons
Given an array of size N. The task is to find the maximum and the 
minimum element of the array using the minimum number of comparisons.
*/


/*
Approach 1 : using two comparison for each number
*/

#include<iostream>
#include<algorithm>
#include<climits>

using namespace std;

int main(){
    int arr[] = {3, 5, 4, 1, 9};
    int size = sizeof(arr)/sizeof(arr[0]);

    int minVal = INT_MAX;
    int maxVal = -1;

    for(int i=0; i<size; i++){
        if (arr[i] > maxVal) maxVal = arr[i];
        if (arr[i] < minVal) minVal = arr[i];
    }

    std::cout << " Minimum value = " << minVal << " and Maximum value = " << maxVal << std::endl; 
}


/*
Approach 2 : using three comparison for two number
This is optimization from appproach 1.
For each pair of number only 3 comparisons will take place.

Number of comparisons = 3n/2.
*/
#include<iostream>
#include<algorithm>
#include<climits>

using namespace std;

int main(){
    int arr[] = {3, 5, 4, 1, 9};
    int size = sizeof(arr)/sizeof(arr[0]);

    int minVal = INT_MAX;
    int maxVal = -1;

    for(int i=0; i<size/2; i++){
        if(arr[2*i] < arr[2*i+1]){
            minVal = std::min(minVal, arr[2*i]);
            maxVal = std::max(maxVal, arr[2*i+1]);
        } else {
            minVal = std::min(minVal, arr[2*i+1]);
            maxVal = std::max(maxVal, arr[2*i]);
        }
    }
    if(size%2 == 1){
        minVal = std::min(arr[size-1], minVal);
        maxVal = std::max(arr[size-1], maxVal);
    }

    std::cout << " Minimum value = " << minVal << " and Maximum value = " << maxVal << std::endl; 
}