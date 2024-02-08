/*
Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        //Step 1: Make each element = k be in the (k-1)th position
        for(int i=0;i<nums.size();i++){
          if(nums[i]==i+1)  continue; 
          
          //this runs total O(N) times combined for all iteration of outer for loop
          //since, we have at most n distinct elements, placing each element in its position will take total O(N) ->
          while(nums[i] != i+1 //element already at position
              && nums[i] != nums[nums[i]-1]){  //cycle

            swap(nums[i], nums[nums[i]-1]);
          }           
        }

        //for(int i=0;i<nums.size();i++) cout<<nums[i]<<endl;

        vector<int> ret;

        //Step 2: if for the index k, the value is not k+1, we know that cell's element is missing
        for(int i=0;i<nums.size();i++){
          if(nums[i] != i+1)  ret.push_back(i+1);
        }

        return ret;
    }
};
