import java.io.*;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No

class MaxandMin {

public static void main (String[] args) {

int n,max,min;

n=7;

int[] arr = new int[]{2,8,6,2,11,5,70};

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

