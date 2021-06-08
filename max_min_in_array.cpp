// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this -

#include<iostream>
#include<vector>
#include<bits/stdc++.h>
#include<algorithm>
using namespace std;

int main()
{
    vector<int> vect{4,3,2,7,8,2,3,1};

    int min_num = INT_MAX;
    int max_num = INT_MIN;
    int i = 0;

    int n = vect.size();

    // Even Length situation
    if(n % 2 == 0)
    {
        min_num = min(vect[0], vect[1]);
        max_num = max(vect[0], vect[1]);
        i = 2;
    }
    // Odd Length situation
    else
    {
        min_num = vect[0];
        max_num = vect[0];
        i = 1;
    }

    // Iterate in Pairs of 2
    // Reduces number of comparisons
    for(; i < n; i += 2)
    {
        if(vect[i] < vect[i+1])
        {
            if(vect[i] < min_num)
                min_num = vect[i];

            if(vect[i+1] > max_num)
                max_num = vect[i+1];
        }
        else
        {
            if(vect[i+1] < min_num)
                min_num = vect[i+1];
        
            if(vect[i] > max_num)
                max_num = vect[i];
        }
    }

    cout << endl << "Min  " << min_num << endl;
    cout << "Max  " << max_num << endl;

    return 0;
}