//448. Find All Numbers Disappeared in an Array


/*
Since we need to use O(1) space, inplace modification is needed.
Iterate over the array elements and mark the (current ele - 1)th index negative
Again iterate over the array, the index which have positive numbers are missing elements, so push back index+1 to result
Doing +1 and -1 because the numbers start from 1 to n.

Time complexity: O(N)
Space complexity: O(1)

*/

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {

        vector<int> ret;
        for(int i=0; i<nums.size();i++){
            int idx = abs(nums[i])-1;
            if(nums[idx] > 0) nums[idx] *= -1;
        }

        for(int i=0; i<nums.size(); i++){
            if(nums[i]>0) ret.push_back(i+1);
            else nums[i] *= -1; //to get original array back
        }
        
        return ret;
    }
};