class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> result;// array to store the missing numbers
        int n = nums.size();
        for(int i = 0 ; i < n ; i++){
            int index  = abs(nums[i]) - 1; // get the index corresponding to the current number
            if(nums[index] > 0){
                nums[index] *= -1;//if +ve make it -ve
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(nums[i]>0){
                result.push_back(i+1);//if +ve add to the result array 
            }else{
                nums[i] *= -1;//restores the values back to +ve
            }
        }
        return result;
        
    }
};