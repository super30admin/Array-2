// Approach 1
// Time Complexity - O(n) - Since we are iterating over the 'nums' vector with 'n' elements.
// Space Complexity - O(n) - Since we are initializing an vector 'helper' with of size same as vector 'nums'.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> answer;
        
        vector<bool> helper(nums.size(), false);
        
        
        for(int i = 0; i < nums.size(); i++){
            helper[nums[i]-1] = true;
        }

        int n = helper.size();
        for(int j = 0; j < n; j++){
            if(helper[j] == false)
                answer.push_back(j+1);
        }
        
        return answer;
    }
};

// Approach 2 - A slightly different approach. I use a set here instead of a vector.
// Time Complexity - O(n) - Since we are iterating over the 'nums' vector with 'n' elements.
// Space Complexity - O(n) - Since we are initializing a set that would be of size 'n.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        set<int> set1;
        vector<int> answer;
        
        for(int i = 0; i < nums.size(); i++){
            if(!set1.count(nums[i]))
                set1.insert(nums[i]);
        }
        
        for(int j = 1; j <= nums.size(); j++){
            if(!set1.count(j))
                answer.push_back(j);
        }
        return answer;
    }
};

// Approach 3 - State change approach.
// Time Complexity - O(n) - Since we are iterating over the 'nums' vector with 'n' elements.
// Space Complexity - O(1) - We are not using an extra space for this solution.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> answer;
        
        for(int i = 0; i < nums.size(); i++){
            if(nums[abs(nums[i]) - 1] > 0)
                nums[abs(nums[i]) - 1] *= -1; 
        }
        
        for(int j = 0; j < nums.size(); j++){
            if(nums[j] > 0)
                answer.push_back(j+1);
            else
                nums[j] *= -1;
        }
        return answer;
    }
};