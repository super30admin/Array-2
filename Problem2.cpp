// Time Complexity : O(n)
// Space Complexity : O(1) no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, but referred approaches from Geeks for Geeks link

#include<iostream>

using namespace std;
  
struct Pair
{
    int min;
    int max;
};
 
struct Pair getMinMax(int arr[], int n)
{
    struct Pair minmax;    
    int i;
     
    if (n % 2 == 0) // If even length then first two elements as max and min
    {
        if (arr[0] > arr[1])    
        {
            minmax.max = arr[0];
            minmax.min = arr[1];
        }
        else
        {
            minmax.min = arr[0];
            minmax.max = arr[1];
        }
 
        i = 2;
    }
     
    //if odd then element will be both max and min
    else
    {
        minmax.min = arr[0];
        minmax.max = arr[0];

        i = 1;
    }
     
    while (i < n - 1)
    {        
        if (arr[i] > arr[i + 1])        // Compare pairs with min and max
        {
            if(arr[i] > minmax.max)    
                minmax.max = arr[i];
                 
            if(arr[i + 1] < minmax.min)        
                minmax.min = arr[i + 1];    
        }
        else       
        {
            if (arr[i + 1] > minmax.max)    
                minmax.max = arr[i + 1];
                 
            if (arr[i] < minmax.min)        
                minmax.min = arr[i];    
        }
         
        i += 2;     // move to next pair
    }        
    return minmax;
}
 

int main()
{
    int arr[] = { 1000, 11, 445,
                1, 330, 3000 };
    int arr_size = 6;
     
    Pair minmax = getMinMax(arr, arr_size);
     
    cout<<"\n Minimum element is "<<minmax.min;
    cout<<"\n Maximum element is "<<minmax.max;
         
    return 0;
}