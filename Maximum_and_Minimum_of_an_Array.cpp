/*
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
*/
#include <bits/stdc++.h>
#include <iostream>

using namespace std;

    std::vector<int> maxmin(std::vector<int>& nums) {
        int mn = INT_MAX;
        int mx = INT_MIN;
        if(nums.size()==0){
            return {{0,0}};
        }
        for(int i = 0; i< nums.size()-1; i++){
            if(nums[i]>nums[i+1]){
                mn = min(mn,nums[i+1]);
                mx = max(mx,nums[i]);
            } else{
                mn = min(mn,nums[i]);
                mx = max(mx,nums[i+1]);
            }
        }
        return {mn,mx};
    }

int main(){
    std::vector<int> n = {9,3,4,6,2,8,1};
    std::vector<int> ans = maxmin(n);
    cout<<ans[0]<<" "<<ans[1];
    return 0;
}