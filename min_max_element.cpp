// Time Complexity : O(n) : 5(n-1)/2 comparisons
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//1. Edge case
//A. return if size 0 or 1 or 2

//2. technique
//A. compare in pairs to get the result

#include <iostream>
#include <vector>
using namespace std;

class Solution{
    
public:
    vector<int> min_max_number(vector<int> nums){
        //1.
        if(nums.size()==0 ){
            vector<int> result(2,0);
            return  (result);
        }
        if(nums.size()==1){
            vector<int> result={nums[0], nums[0]};
            return  (result);
        }
        
        int min = nums[0];
        int max = nums[0];
        int pair_min=0, pair_max=0; int j=0;
        //2
        for(int i=0; i<nums.size(); i=i+2){
            j = (i+1 == nums.size())? i: i+1;
            
            pair_min = nums[i]>nums[j]? nums[j] : nums[i];
            pair_max = nums[i]<nums[j]? nums[j] : nums[i];
            
            min = pair_min< min? pair_min : min;
            max = pair_max>max ? pair_max : max;
        }
        
        vector<int> result={min, max};
        return result;
    }
};

int main(void){
    
    Solution s1;
    
    vector<int> nums={14, 4, 9, 0, 17, 3, 1, 18,22, 11};
    vector <int> result;

    result = s1.min_max_number(nums);

   cout<<result[0]<<"\t"<<result[1]<<"\n";
    return 0;
}
