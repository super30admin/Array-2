//
// Created by shazm on 7/20/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
#include <set>

using namespace std;

class Solution{
public:
    vector<int> prob(vector<int>& nums, int k){
        map<int,int> hashMap; set<int> hashset;
        int target = nums.size()/k;
        for(int x = 0; x<nums.size(); x++){
            if(hashMap.find(nums[x])!=hashMap.end()){
                hashMap[nums[x]] = hashMap[nums[x]]+1;
                if(hashMap[nums[x]]>target){
                    hashset.insert(nums[x]);
                }
            }else{
                hashMap.insert(pair<int,int>(nums[x],1));
            }
        }
        vector<int> retVec(hashset.begin(),hashset.end());
        return retVec;
    }
};

int main(){
    Solution s;
    vector<int> vec{3, 1, 2, 2, 1, 2, 3, 3};
    for(int x : s.prob(vec,4)){
        cout<<x<<endl;
    }
    return 0;
}