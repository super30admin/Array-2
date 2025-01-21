#include <bits/stdc++.h>
#include <vector>
#include <iostream>
using namespace std;

vector<int> findDisappearedNumbers(vector<int>& nums) {
    vector<int>ans;
    int n = nums.size();
    for(int i=0;i<=n-1;i++) if(nums[abs(nums[i])-1]>0) nums[abs(nums[i])-1]*=-1;
    for(int i=0;i<=n-1;i++) if(nums[i]>0) ans.push_back(i+1);
    return ans;
}

int main(){
    vector<int> nums = {4,3,2,7,8,2,3,1};
    vector<int> ans = findDisappearedNumbers(nums);
    for(auto x:ans) cout<<x<<" ";
    return 0;
}