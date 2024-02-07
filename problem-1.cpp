// 448. Find All Numbers Disappeared in an Array
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

/* 
    to check which number is disappeared in the array we will traverse the from 1 to n and 
    mark all the elements which are to array as negative recespective to the in index and again traverse the array
    and all the positive elements indices are missing elements

*/


// Your code here along with comments explaining your approach
vector<int> findDisappearedNumbers(vector<int>& nums) {
    int n = nums.size(), idx;
    vector<int> ans;
    for(int i = 0; i < n; i++)
    {
        idx = abs(nums[i]) - 1;
        if(nums[idx] > 0)
        nums[idx] = -(nums[idx]);
    } 
    for(int i = 0; i < n; i++)
    {
        if(nums[i] > 0)
        ans.push_back(i+1);
    }
    return ans;
}
