// Time complexity O(n)
// Space complexity O(1)

class Solution {
  public:
    pair<int, int> getMinMax(vector<int> arr) {
        // code here
        auto min = *min_element(arr.begin(), arr.end());
        auto max = *max_element(arr.begin(), arr.end());
        return {min, max};
    }
};