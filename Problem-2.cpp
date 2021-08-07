//Time Complexity = O(N)
//Space Complexity = O(1)
//The total number of comaprison over here is 2*N;
//Where N is the size of the array.
#include<bits/stdc++.h>
using namespace std;

int main()
{
    vector<int> arr{7,2,6,1,4,6,7,9,7,5,3,2,0};
    int Max=INT_MIN, Min=INT_MAX;
    for(int i=0;i<arr.size();i++)
    {
        Max=max(Max,arr[i]);
        Min=min(Min,arr[i]);
    }
    cout<<"Max is:"<<Max<<endl;
    cout<<"Min is:"<<Min<<endl;
    return 0;
}


//Time Complexity = O(N)
//Space Complexity = O(1)
//The total number of comaprison over here is 3*(N/2);
//Where N is the size of the array.
#include<bits/stdc++.h>
using namespace std;

int main()
{
    vector<int> arr{7,2,6,1,4,6,7,9,7,5,3,2,0};
    int Max=INT_MIN, Min=INT_MAX;
    for(int i=0;i<arr.size();i+=2)
    {
        if(arr[i]<arr[i+1])                                   //1st Comparison.
        {
            Max=max(Max,arr[i+1]);                            //2nd Comparison.
            Min=min(Min,arr[i]);                              //3rd Comparison.
        }
        else{
            Max=max(Max,arr[i]);                              //2nd Comparison.
            Min=min(Min,arr[i+1]);                            //3rd Comparison.
        }
    }
    cout<<"Max is:"<<Max<<endl;
    cout<<"Min is:"<<Min<<endl;
    return 0;
}
