// Time Complexity : O(N)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// if nums[i]<nums[i-1] we need to compare each with max and min element

int min=INT_MAX;
int max=IT_MIN;

for(int i=1;i<arr.size();i++)
{
    if(arr[i]<arr[i-1])
    {
         min=min(min,arr[i]);
         max=max(max,arr[i-1]);
    }
    else
    {
        min=min(min,arr[i-1]);
        max=max(max,arr[i]);

    }
}