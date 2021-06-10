// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : NA
// the approach is to consider elements not as induvidually but as pairs and redce the comparisons to 3n/2


class Solution
{
   public:
   int max=0;
   int min=0;

   vector<int> findMinMax(vector<int> arr)
   {
       vector<int> temp;
       if(arr.size()%2==0)
       {
           max=INT_MIN;
           min=INT_MAX;
           for(int i=0;i<arr.size()-1;i++)
           {
               if(arr[i]>arr[i+1])
               {
                   min=std::min(arr[i+1],min);
                   max=std::max(arr[i],max);
               }
               else
               {
                   min=std::min(arr[i],min);
                   max=std::max(arr[i+1],max);
               }
           }
           temp.push_back(min);
           temp.push_back(max);
           return temp;
        }
        else
        {
            max=arr[0];
            min=arr[0];
            for(int i=1;i<arr.size()-1;i++)
            {
                if(arr[i]>arr[i+1])
               {
                   min=std::min(arr[i+1],min);
                   max=std::max(arr[i],max);
               }
               else
               {
                   min=std::min(arr[i],min);
                   max=std::max(arr[i+1],max);
               }
            }
             temp.push_back(min);
             temp.push_back(max);
             return temp;
        }
    }
   
};
