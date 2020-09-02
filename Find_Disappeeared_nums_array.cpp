// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach




class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
      int size = nums.size();
        vector<int> result;

        // iterate through all the elements and for each of the element at any index.. go to that index value and update the 
        // numer there to negative value. SO at the end whatever indexes which are remained with positive values
        // will be out missing values.

        for (int i = 0; i < size ; i++){
            int temp = abs(nums[i]); 
            
            // updating the numbers to negative only if they are positive. Some might repeat and then if there is no condition
            // it might revert to positive
            if ( nums[temp-1] >0){
                nums[temp-1] *= -1;
            }
        }
        // looping through updated array to check for positve values.
        
        for ( int i = 0; i <size; i++){
            if ( nums[i] >0){
                // adding i+1 to result as the index is less than the number by 1.  i.e starts from 0.
                result.push_back(i+1);
            }
        }
        return result;
    }
};