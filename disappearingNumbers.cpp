
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*

*/
#include <iostream>

#include <vector>

using namespace std;




class Solution {

public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {

        vector<int> result;

        int n = nums.size();

        for(int i=0;i<n;i++){
            int index = abs(nums[i])-1;
            if(nums[index]>0){
                nums[index]*= -1;


            } 


        }

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result.push_back(i+1);
            }
            else{
                 nums[i]*= -1;
            }
        }

        return result;






        
        
    }
};