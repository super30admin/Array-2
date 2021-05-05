// Time complexity-O(3n)
// space complexity O(1);
// Did this code successfully run on Leetcode :no
// Any problem you faced while coding this : no

// we try to reduce number of comparisons to 3 instead of 4 in the case of the naive solution
// we compare the element in pairs 

#include <iostream>
using namespace std;
 
// Naive solution to find the minimum and maximum number in an array
void findMinAndMax(int arr[], int n, int &min, int &max)
{
    // initialize minimum and maximum element with the first element
    max = arr[0], min = arr[0];
 
    // do for each array element
    for (int i = 1; i < n; i++)
    {
        // if the current element is greater than the maximum found so far
        if (arr[i] > max) {
            max = arr[i];
        }
 
        // if the current element is smaller than the minimum found so far
        else if (arr[i] < min) {
            min = arr[i];
        }
    }
}
 
int main()
{
    int arr[] = { 5, 7, 2, 4, 9, 6 };
    int n = sizeof(arr)/sizeof(arr[0]);
 
    // to store minimum and maximum element, respectively
    int min, max;
 
    findMinAndMax(arr, n, min, max);
 
    cout << "The minimum array element is " << min << endl;
    cout << "The maximum array element is " << max;
 
    return 0;
}

#include <iostream>
#include <climits>
using namespace std;
 
// Optimized solution to find the minimum and maximum number in an array
void findMinAndMax(int arr[], int n, int &min, int &max)
{
    // initialize minimum element by `INFINITY` and the maximum element
    // by `-INFINITY`
    max = INT_MIN, min = INT_MAX;
 
    // if the array has an odd number of elements, ignore the last
    // element and consider it later
    bool odd = n & 1;
    if (odd) {
        n--;    // comparison
    }
 
    // compare elements in pairs, i.e., `arr[i]` and `arr[i+1]`
    for (int i = 0; i < n; i = i + 2)
    {
        int maximum, minimum;
 
        // find the maximum and minimum among `arr[i]`, `arr[i+1]`
 
        if (arr[i] > arr[i + 1]) {  // 1st comparison
            minimum = arr[i + 1],
            maximum = arr[i];
        }
        else {
            minimum = arr[i],
            maximum = arr[i + 1];
        }
 
        // update max
        if (maximum > max) {        // 2nd comparison
            max = maximum;
        }
 
        // update min
        if (minimum < min) {        // 3rd comparison
            min = minimum;
        }
    }
 
    // handle the last element if the array has an odd number of elements
 
    if (odd)                        // comparison
    {
        if (arr[n] > max) {         // extra comparison for an odd element
            max = arr[n];
        }
 
        if (arr[n] < min) {         // extra comparison for an odd element
            min = arr[n];
        }
    }
}
 
int main()
{
    int arr[] = { 4, 7, 5, 1, 3 };
    int n = sizeof(arr) / sizeof(arr[0]);
 
    // to store minimum and maximum element, respectively
    int min, max;
 
    findMinAndMax(arr, n, min, max);
 
    cout << "The minimum array element is " << min << endl;
    cout << "The maximum array element is " << max;
 
    return 0;
}