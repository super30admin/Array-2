//Numbers disappeared in an array

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {

        vector<int>result;
        if(nums.empty() || nums.size() == 0) return result;
        int len = nums.size();

        for(int i = 0; i < len; i++){
            //Making the elements negative according to the indices
            int index = abs(nums[i]) - 1;   // index starts from 0
            if (nums[index] > 0) nums[index] *= -1;
        }

        //checking for the elements that are not negative
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] > 0)
                result.push_back(i + 1);

        }



    return result;

    }
};


//Time Complexity: O(n)
//Space Complexity:O(1),result vector not considered
