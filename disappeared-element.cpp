/*The code utilizes the fact that each element in the array represents a number, and we can use the array itself to mark the presence of numbers.
It first iterates through the array and negates the value at the index corresponding to the absolute value of each element encountered.
After negating, the indices with positive values indicate the missing numbers, and their corresponding numbers are added to the result vector.
Time Complexity: O(n), where n is the size of the input array.
Space Complexity: O(1) as the result vector is not considered in the space complexity calculation. The algorithm modifies the input array in-place.*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
     vector<int> findDisappearedNumbers(vector<int>& nums) {
       vector<int>result;
       int n=nums.size();
       for(int i=0;i<n;i++){
           int number=abs(nums[i]);
           int idx=number-1;
           if(nums[idx]>0){
               nums[idx]*=-1;
           }
       }
       for(int i=0;i<n;i++){
           if(nums[i]>0){
               result.push_back(i+1);
           }
       }
       return result;
    }
};