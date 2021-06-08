//O(n), O(1)
//mark appeared nos as negative, reiterate and find ones missing

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> result;
        for(int n : nums){
            //cout << n<<" n "<<'\n';
            if(nums[abs(n) - 1] > 0){
                nums[abs(n) - 1] = -nums[abs(n) -1];
               // cout <<nums[abs(n)-1]<<'\t'; 
            }
        }
         for(int i = 0; i < nums.size();++i){
            if(nums[i] < 0)
                continue;
            else
                result.push_back(i + 1);
        }
        return result;
    }
};