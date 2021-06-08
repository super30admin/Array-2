#include <bits/stdc++.h>
using namespace std;
//O(1) space eitherways, since we aren't using anything auxillary
//this is normal route with 2*n-2 comparisions;  
vector<int> std_route(vector<int> arr){
    int minimum = arr[0];
    int maximum = arr[0];
    for(int i=1;i<arr.size();i++){
        minimum = min(minimum,arr[i]);
        maximum = max(maximum,arr[i]);
    }
    return {minimum,maximum};
}
//lets play a tournament here, thanks dragon-ball Z for giving me this idea, yamacha vs teen goku was dope AF
//3n/2 comparisions, at the most, look at ipl at semi finals for explaination
//4 teams, 4 matches, that's it
vector<int> jugaad_route(vector<int> arr){
   //we have not got the last element here
   int n = arr.size();
    if(arr.size()==1) return {arr[0],arr[0]};
    
    int mini = INT_MAX;
    int maxi = INT_MIN;
    if(arr[1]>arr[0]){
        mini = arr[0];
        maxi = arr[1];
    }
    if(arr.size()==2) return {mini,maxi};
    int i;
    if(arr.size()%2==0) i=2;
    else i =1;
    while(i<n-1){
        if(arr[i]>arr[i+1]){
            if(arr[i]>maxi)
                maxi = arr[i];
            if(arr[i+1]<mini)
                mini = arr[i+1];
        }
        else{
            if(arr[i+1]>maxi)
                maxi = arr[i+1];
            if(arr[i]<mini)
                mini = arr[i];
        }
        i+=2;
    }
    return {mini,maxi};
}
int main()
{
    vector<int> arr = {2,4,5,67,132,645665,43};
    vector<int> res = jugaad_route(arr);
    cout << res[0]<<"   "<<res[1];
    return 0;
}