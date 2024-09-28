// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


import java.io.*;
class GFG {
public static void main (String[] args) {
int n,max,min;
n=7;
int[] arr = new int[]{2,3,4,1,3,4,5,7,2,4,2,6,8,9};
max=arr[0];
min=arr[0];
for(int i=0;i<n;i=i+2)
{
  if(i==n-1)
  {
      if(arr[i]>max) max=arr[i];
      if(arr[i]<min) min=arr[i];
  }
  else if(arr[i]>arr[i+1])
  {
      if(arr[i]>max) max=arr[i];
      if(arr[i+1]<min) min=arr[i+1];
  }
  else
  {
      if(arr[i+1]>max) max=arr[i+1];
      if(arr[i]<min) min=arr[i];
  }
}
System.out.println(max);
System.out.println(min);
}
}