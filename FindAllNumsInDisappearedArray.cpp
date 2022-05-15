//O(N) time
//O(N) Space 
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> result(nums.size()+1);
        for(int i=0;i<nums.size();i++){
            result[nums[i]] = 1;
        }
        
        int left=0, right=0,flag=0;
        for(int i=1;i<result.size();i++){
            if(result[i]!=1){
                if(flag==0) {
                    left=i;
                    flag++;
                }
                else right=i;
            }
        }
        
        if(left==0 && right==0) return{};
        if(right==0) return {left};
        
        vector<int> ans;
        for(int i=left;i<=right;i++){
            if(result[i]==0) ans.push_back(i);
        }
        return ans;
    }
};

STATE CHANGE :
//O(N) time
//O(1) Space

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> result;
        //State Change
        for(int i=0;i<nums.size();i++){
            int x;
            if(nums[i]>0){
                x = nums[i]-1;
            }else{
                x = (-1*nums[i])-1;
            }
            nums[x] = (nums[x]>0) ? nums[x]*-1 : nums[x];
        }

        //Recording positive indexes and reverting state of array
        for(int i=0;i<nums.size();i++){
            if(nums[i]>0) result.push_back(i+1);
            else nums[i]*-1;
        }
        return result;
    }
};
