#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
Convert all the elements into its negative indices and then if 
any of the element is greater than 0 push into the result vector i+1
*/
class Solution{
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int n=nums.size();

        for(int i=0;i<n;i++){
            int num = abs(nums[i]);
            int idx = num-1;

            if(nums[idx]>0){
                nums[idx] = nums[idx]* -1;
            }
        }

        vector<int> result;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result.push_back(i+1);
            }
        }
        return result;
    }

};
