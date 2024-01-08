// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Geeks For Geeks Yes
// Any problem you faced while coding this :No
#include <bits/stdc++.h>
using namespace std;

pair<long long, long long> getMinMax(long long A[], int N) {
        long long minNum = LLONG_MAX;
    	long long mAxNum = LLONG_MIN;
    	int i=0;
    	if(N%2!=0)
    	{
    	    minNum = A[0];
            mAxNum = A[0];
            i=1;
    	}
    	for(;i<N;i+=2)
    	{
    	    if(A[i]<A[i+1])
    	    {
    	        minNum=min(minNum,A[i]);
    	        mAxNum = max(mAxNum,A[i+1]);
    	    }
    	    else
    	    {
    	        minNum=min(minNum,A[i+1]);
    	        mAxNum = max(mAxNum,A[i]);
    	    }
    	}
    
    	return {minNum, mAxNum};
}