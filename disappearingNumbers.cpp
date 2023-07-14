
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
we first iterate over all the possible elements(values) in the array and we find the 
index of the element as if they were sorted and unique. In such a case, the values from 
1-n will have indexes 0-n-1, meaning the index of the element would be element-1.
we iterate over the elements and we find the index of the element and then we muliply it
with negative 1 to show that the element(index+1) at this index exists. 

we again iterate over the elements and we find the missing numbers by finding elements which
are greater than 0. If not greater than 0, we convert them back to their original non negative values.


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