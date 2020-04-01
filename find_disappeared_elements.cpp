// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : np
// Your code here along with comments explaining your approach
//1.Edge case
//A. return if nums.size() is zero or one 
//2. Approach 1:
//A. change using absolute values - concise code

//3. Approach 2 :
//B. Elaborate codes with multiple checks
class Solution {
     vector<int> approach_1(vector<int>& nums) {
       vector<int>  ans; 
      int  numsSize = nums.size();

      for (int i=0; i<numsSize; i++){
         nums[abs(nums[i])-1] = -abs(nums[abs(nums[i])-1]);
       }
      for(int i=0;i<numsSize;i++){
          if(nums[i]>0){
               ans.push_back(i+1);    
          }
      }        
        return ans;
     }
    
     vector<int> approach_2(vector<int>& nums) {
         vector<int>  ans; 
         int  numsSize = nums.size();
         
         for (int i=0; i<numsSize; i++){ 
            int index =  abs(nums[i])-1; // get the index which is present in the array 
            
            if(nums[index]>0){
                nums[index] =-nums[index];
            }
         }
         
        for (int i=0; i<numsSize; i++){
            if(nums[i]>0){
                ans.push_back(i+1);
            }
        }
         return ans;
     }
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        //1.
        if(nums.size()==0 || nums.size()==1){
            return nums;
        }
        //2.
        //return approach_1(nums);
        //3.
        return approach_2(nums);
    }
};
