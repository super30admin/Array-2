//  428_Find_All_Numbers_Disappeared_in_Array
//TC: O(N), SC:O(1)

#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
       //by changing magnitude of elemnts in array
        
        //TC: O(N), SC:O(1)
        if(nums.size()==0)
            return vector<int>();
        vector<int> output;
        for(int i=0;i<nums.size();i++){
            //change the magnitude of element present at nums[i] index
            //if magnitude has already changed, take abs of nums[i].
            int v=abs(nums[i])-1;
            //if it is already visited no need to change magnitude again
            if(nums[v]>0){
                nums[v]=-nums[v];
            }
        }
        for(int i=0;i<nums.size();i++){
            if(nums[i]>0)
                output.push_back(i+1);
        }
        return output;
       
       
       /*
       using set - TC:O(n), SC:O(m), n size of array, m being unique elements
       if(nums.size()==0)
            return vector<int>();
        unordered_set<int> tracker;
        vector<int> output;
        for(int i=0;i<nums.size();i++){
            tracker.insert(nums[i]);
        }
        for(int i=1;i<=nums.size();i++){
            if(tracker.find(i)==tracker.end())
                output.push_back(i);
        }
        return output;*/
        
    }
};

int main(int argc, const char * argv[]) {
    Solution s;
    vector<int> nums{4,3,2,7,8,2,3,1};
    vector<int> output=s.findDisappearedNumbers(nums);
    for(int i:output){
        cout<<i<<"\t";
    }
    return 0;
}
