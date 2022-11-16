// Time Complexity : O(n) => O(3(n/2)) => n/2 comparisons for pairComparison + n/2 (min comparisons) + n/2 (max comparisons)
// Space Complexity : O(1) 


//we are comparing with each number 
//reducing this further would be by taking paris
//TC: O(2n) = O(n)
// for(int n:nums){
//     if(n < min)
//         min = n;
//     else if (n > max)
//         max = n;
// }


#include <bits/stdc++.h>
using namespace std;


class Solution {
    private:
        std::pair<int, int> pairComparison(int x, int y){
            if(x<y)
                return pair<int, int>({x,y});
            return pair<int, int>({y,x});
        }
    public:
        std::vector<int> getMinMax(vector<int>& nums){
            if(nums.size() == 0)
                return vector<int>();
            int n = nums.size();
            int min_ = INT_MAX;
            int max_ = INT_MIN;
            
            for(int i=0; i<n; i+=2){
                std::pair<int, int> pair = pairComparison(nums[i], nums[i+1]);
                min_ = min(min_, pair.first);
                max_ = max(max_, pair.second);
            }
            if(n % 2) {
                min_ = min(min_, nums[n-1]);
                max_ = max(max_, nums[n-1]);
            }
            return vector<int>({min_, max_});
        }
};

int main()
{
    std::vector<int> nums ({4, 7, 2, 3, 10, 100, -1, 20, -10}) ;
    std::vector<int> result;
    Solution s;
    result = s.getMinMax(nums);
    if(result[0] == -10 and result[1] == 100)
        cout<<"Correct solution!";
    else
        cout<<"Incorrect solution!";
}
