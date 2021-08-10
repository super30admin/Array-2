//Time Complexity - O(N)
//Space Complexity - O(1)

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int>v;
        for(int i=0;i<nums.size();i++){
            int x;
            if(nums[i]<0){
                x=-1*nums[i];
                x--;
            }
            else if(nums[i]>0)
            {
                x=nums[i]-1;
            }
            if(nums[x]>0)
                nums[x]= -1*nums[x];
        }
        for(int i=0;i<nums.size();i++){
            if(nums[i]>0)
                v.push_back(i+1);
            else{
                nums[i]=-1*nums[i];
            }
        }
        return v;
    }
};