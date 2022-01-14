// Time Complexity : O(n) m-> number of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


#include<stdio.h>
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        
        vector<int> result;
        for(int i=0; i<nums.size(); i++){
            int val = abs(nums[i])-1;
            if(nums[val]<0){
		continue;
            }else{
                nums[val]=nums[val]*-1;  // Make the nums[index] negative
            }
        }
            for(int i=0; i< nums.size(); i++){
                if(nums[i]>=0) result.push_back(i+1); // Push all the nums[index] which are not negative to resultant array
            }
        return result;
        }
};
