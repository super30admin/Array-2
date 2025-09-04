// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We keep a global min and max variable to keep track of the min and max 
// We compare in pairs: the larger element of the pair is compared to the max and the smaller element is compared to the min
// This way we reduce the total comparisons required from 2n to 3n/2

// User function Template for C++
class Solution {
  public:
    pair<int, int> getMinMax(vector<int> arr) {
        // code here
        int n = arr.size();
        if(n == 1) return {arr[0], arr[0]};
        int globalMin = INT_MAX;
        int globalMax = INT_MIN;
        
        for(int i=0 ; i<n-1; i++) {
            if(arr[i] > arr[i+1]) {
                globalMax = max(globalMax, arr[i]);
                globalMin = min(globalMin, arr[i+1]);
            } else {
                globalMax = max(globalMax, arr[i+1]);
                globalMin = min(globalMin, arr[i]);
            }
        }
        return {globalMin, globalMax};
    }
};