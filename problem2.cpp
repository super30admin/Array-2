
// TC: O(n) ( (1+2)*n/2 + 2) total comparisons
// SC: O(1)

// Did code run on leetcode: no ( checked it localy on the system)
// Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison


#include <iostream>
#include <vector>
using namespace std;

pair<int,int> f(int Maximum, int Minimum, vector<int> &arr);
int main()
{
    vector<int>arr = {3,5,1,3,7,9,5,-1};
    int Maximum = arr[0];
    int Minimum =  arr[0];
    pair<int,int>ans = f(Maximum,Minimum,arr);
    cout << "Maximum is: "<< ans.first<< " Minumum is: "<< ans.second;
}
pair<int,int> f(int Maximum, int Minimum, vector<int> &arr)
{
    int n =  arr.size();
    for(int i=1;i<n;i++)
    {
        if(arr[i]>arr[i-1])
        {
            Maximum = max(Maximum, arr[i]);
            Minimum = min(Minimum,arr[i-1]);
        }
        else{
            Maximum = max(Maximum, arr[i-1]);
            Minimum = min(Minimum,arr[i]);
        }
    }
    if(n%2==1)
    {
        Maximum = max(Maximum, arr[n-1]);
        Minimum = min(Minimum,arr[n-1]);
    }
    return {Maximum,Minimum};
}
