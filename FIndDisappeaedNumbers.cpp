class Solution {
    // TC - O(n)
    // SC - S(1)
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> nums1;
        
        for (int i=0 ; i<nums.size();i++){
            if( nums[abs(nums[i])-1] >0){
            nums[abs(nums[i])-1] = -(nums[abs(nums[i])-1]);
            }
        }

        for (int i=0 ; i<nums.size();i++){
            if(nums[i]>0){
                nums1.push_back(i+1);
            }
        }
        return nums1;
    }
};