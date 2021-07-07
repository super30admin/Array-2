// min amd max in array

#include <iostream>
#include <vector>
using namespace std;

int main() {
    vector<int>nums = {10, 34, 100, 1, -8, 23};
    int max = nums[0], min = nums[0];

    for(int i = 1; i < nums.size() ; i = i+2){

        if(i == nums.size() - 1){
            min = std::min(min, nums[i]);
            max = std::max(max, nums[i]);
        }
        else if(nums[i] > nums[i+1]){
            min = std::min(min, nums[i+1]);
            max = std::max(max, nums[i]);
        }
        else if(nums[i] < nums[i+1]){
            min = std::min(min, nums[i]);
            max = std::max(max, nums[i+1]);
        }
    }

    cout<< "The maximum number is " << max << endl;
    cout<< "The minimum number is " << min << endl;
    return 0;
}

//Time complexity: O(n)
//Space complexity: O(1)
