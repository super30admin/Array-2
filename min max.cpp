// as discussed in class
// time: O(n), but reduced - O(1.5n) instead of O(2n)
// space: O(1)
void minMax (vector<int> &nums) {
    int minVal = INT_MAX, maxVal = INT_MIN;
    for(int i = 0; i < nums.size()-1; i+=2) {
        if(nums[i] > nums[i+1]) {
            minVal = min(minVal, nums[i+1]);
            maxVal = max(maxVal, nums[i]);
        }
        else {
            minVal = min(minVal, nums[i]);
            maxVal = max(maxVal, nums[i+1]);
        }
    }
    if(nums.size() % 2 == 1) {
        minVal = min(minVal, nums[nums.size()-1]);
        maxVal = max(maxVal, nums[nums.size()-1]);
    }
    cout<<minVal<<" "<<maxVal;
}
int main() {
    vector<int> nums = {22,14,8,17,35,3};
    minMax(nums);
}