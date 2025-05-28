#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    pair<int, int> MinMax(vector<int>& arr) {
        int n = arr.size();
        int mini = INT_MAX, maxi = INT_MIN;

        int i = 0;
        while (i + 1 < n) {
            if (arr[i] < arr[i + 1]) {
                mini = min(mini, arr[i]);
                maxi = max(maxi, arr[i + 1]);
            } else {
                mini = min(mini, arr[i + 1]);
                maxi = max(maxi, arr[i]);
            }
            i += 2;
        }

        if (n % 2 == 1) {
            mini = min(mini, arr[n - 1]);
            maxi = max(maxi, arr[n - 1]);
        }

        return {mini, maxi};
    }
};

int main() {
    vector<int> arr = {3, 5, 1, 8, 2};
    Solution sol;
    pair<int, int> result = sol.MinMax(arr);
    cout << "Min: " << result.first << ", Max: " << result.second << endl;
    return 0;
}
