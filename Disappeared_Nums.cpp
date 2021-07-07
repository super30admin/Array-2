Time Complexity-O(n)
Space Complexity-O(1)
Did the code run on Leetcode? Yes

#include <iostream>
#include<vector>
using namespace std;

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int>res;
        if(nums.size()==0)
        {
            return res;
        }
        for(int i=0;i<nums.size();i++)
        {
            if(nums[abs(nums[i])-1]>0)
            {
                nums[abs(nums[i])-1]*=-1;
            }
        }
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]>0)
            {
                res.push_back(i+1);
            }
        }
        return res;
    }
};

int main() {
	vector<int>m={4,3,2,7,8,2,3,1};
	Solution soln;
	vector<int>res=soln.findDisappearedNumbers(m);
	for(int i=0;i<res.size();i++)
	{
	    cout<<res[i]<<" ";	
	    
	}
	return 0;
}