//
// Created by shazm on 7/20/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution{
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> retVec = nums;
        for(int x = 0; x<retVec.size(); x++){
            retVec[abs(nums[x])-1] = -nums[abs(nums[x])-1];
        }
        vector<int>::iterator it = retVec.begin();
        for(int x = 0; x<nums.size();x++){
            if((*it)<0){
                retVec.erase(it);
            }else{(*it)=x+1;it++;}
        }
        return retVec;
    }
};

int main(){
    Solution s;
    vector<int> vec{4,3,2,7,8,2,3,1};
    for(int x : s.findDisappearedNumbers(vec)){
        cout<<x<<endl;
    }
    return 0;
}