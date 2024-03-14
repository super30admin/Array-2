// Approach 1
// Time Complexity : O(n)  ... n is number of elements in given array           
// Space Complexity : O(n)   ..... hasmap is used to store data 
//
// Approach 2 (Optimization in space)
// Time Complexity : O(n)  ... n is number of elements in given array           
// Space Complexity : O(1)   
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leet code : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Given an array nums of n integers where nums[i] is in the range [1, n], 
return an array of all the integers in the range [1, n] that do not appear in nums.
*/

/*
Approach 1 : Using Hashmap
Hashmap is used to store the numbers. Number itself is used as index for the hashmap.
as number of data points are 1 to n; index 0 of hashmap will be unused.
Therefore hashmap is taken with 1 size more.
*/

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<bool>hMap(nums.size()+1, false);
        vector<int>result;
        for(auto i : nums){
            hMap[i] = true;
        }

        for(int i=1; i<hMap.size(); i++){
            if(!hMap[i]){
                result.push_back(i);
            }
        }
        return result;
    }
};


/*
Approach 2 : Optimization for space complexity of O(1)
Modify same array instead of using new vector.
*/

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int>result;

        for(int i=0; i<nums.size(); i++){
            int num = std::abs(nums[i]);
            if(nums[num-1] > 0) nums[num-1] *= -1;
        }

        for(int i=0; i<nums.size(); i++){
            if(nums[i] > 0){
                result.push_back(i+1);
            }
        }
        return result;
    }
};