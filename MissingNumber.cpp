#include<iostream>
#include<vector>
using namespace std;
// Time Complexity : O(N)
// Space Complexity : 1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :NO



// Your code here along with comments explaining your approach

vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> output;
        if(nums.size() == 0)
            return output; 
        int size = nums.size();
        for(int i =0; i < size; i++){
            int newIndex = abs(nums[i]) - 1;
            if(nums[newIndex] > 0){
                nums[newIndex] *= -1;
            }
        }
        
        for(int i=1; i <= size; i++){
            if(nums[i - 1] > 0 ){
                output.push_back(i);
            }
        }
        return output;
    }
