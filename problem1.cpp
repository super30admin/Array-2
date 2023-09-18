//Time complexity : O(n)
//Space complexity: O(1)

//Aproach: store values from 1 to n in a set
// then traverse over array and if you find a number in set
//simply erase it in set and then at the end of the iteration 
//whaterver is remained will be stored in array of missing numebers

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
     /*   unordered_map<int,int> counter; //extra space
        vector<int> res; 
        for(auto n: nums)
        {
            counter[n]++;
        }

        for(int i=0;i<nums.size();i++)
        {
            if(!counter.count(i+1))
            {
                res.push_back(i+1);
            }
        }*/
         vector<int> res; 
        unordered_set<int> set
        for(int i=0;i<nums.size();i++){
            set.insert(i+1);
        }
        for(auto n:nums)
        {
            if(set.count(n))
                set.erase(n);
        }
        for(auto s:set)
            res.push_back(s);
        return res;
    }
};
