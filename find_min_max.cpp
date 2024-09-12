//Time complexity - 3 comparisions are being done here within O(n)
//Space complexity - O(1)

#include <bits/stdc++.h>
using namespace std;

int main() {
	// your code goes here
    int A[] = {};
    if(A.empty())
    {
        cout<<"empty array"<<endl;
        return 0;
    }
    int n=A.size();
    int min=INT_MAX,max=INT_MIN;
    int imin,imax;
    for(int i=0;i<n;i+=2)
    {
        if(A[i]<A[i+1])
        {
            imin=A[i];
            imax=A[i+1];
        }
        else
        {
            imax=A[i];
            imin=A[i+1];
        }
        if(imin<min)
            min=imin;
        if(imax>max)
            max=imax;
    }
    cout<<"Minimum element is "<<min; 
    cout<<"nMaximum element is "<<max; 
	return 0;
}
