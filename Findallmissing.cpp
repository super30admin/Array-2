// Time complexity: O(n)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes

//Approach: 
//1. We iterate through the array and for each element, we mark the element at index (abs(nums[i]) - 1) as negative.
//2. In the second pass, we iterate through the array and if the element is positive, we add the index + 1 to the result vector.
//3. This is because, if the element is positive, it means that the element is not present in the array.

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> result; 
        for(int i = 0; i < nums.size(); i++){
            int index = abs(nums[i]) - 1; 
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] > 0){
                result.push_back(i + 1);
            }
        }
        return result;
    }
};