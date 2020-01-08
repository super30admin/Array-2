#include<iostream>
#include<vector>
#include <algorithm>
using namespace std;

int main(){
    int arr[] = {3,434,34,34,4,67,45};
    int size = sizeof(arr) / sizeof(arr[0]);    

    int largest = arr[0],smallest = arr[0];
    for(int i =1; i < size; i += 2){
        if(i == size - 1){
            largest = max(largest,arr[size - 1]);
            smallest = min(smallest,arr[size - 1]);
        }
        largest = max(largest,max(arr[i],arr[i +1]));
        smallest = min(smallest,min(arr[i],arr[i +1]));    
    }
    cout<<"Maximum Element is:"<<largest<<endl;
    cout<<"Minimum Element is:"<<smallest<<endl;
    return 0;
}