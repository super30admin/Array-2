// Problem - Find max and min using less than 2 * (N-2) comparisons
//  Time Complexity : O(n)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Here we compare in pairs instead of comparing each element to min and max
// 2. We first check if the list is even, then decide the min and max between
// first two elements
// 3. And then at each iteration compare two elements simultaneously giving
// us 1.5 *n comparisons

#include <bits/stdc++.h>
using namespace std;

vector<int> getMinMax(int arr[], int n) {
  int mini = arr[0];
  int maxi = arr[0];

  int i = 1;

  // if size of the list is even
  if (n % 2 == 0) {
    // get first two min and max pairs otherwise they will be skipped
    if (arr[0] > arr[1]) {
      mini = arr[1];
      maxi = arr[0];
    } else {
      mini = arr[0];
      maxi = arr[1];
    }

    i = 2;
  }

  while (i < n - 1) {
    if (arr[i] > arr[i + 1]) {
      mini = min(arr[i + 1], mini);
      maxi = max(arr[i], maxi);
    } else {
      mini = min(arr[i], mini);
      maxi = max(arr[i + 1], maxi);
    }
    i += 2;
  }

  return {mini, maxi};
}

int main() {
  // int arr[] = {1000, 11, 445, 1, 330, 3000, 6000};
  int arr[] = {1000, 11, 2000, 0};
  int arr_size = 4;

  vector<int> minmax = getMinMax(arr, arr_size);

  cout << "Minimum element is " << minmax[0] << endl;
  cout << "Maximum element is " << minmax[1];

  return 0;
}
