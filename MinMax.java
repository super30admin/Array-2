class MinMax
{
static int count = 0;

public static int [] getMinMax(int [] arr, int low, int high)
{
     if(low==high)
     {
         return new int[]{arr[low],arr[low]};
     }
      if(high-low==2)
     {
         if(arr[low]>arr[high]) return new int[]{arr[high],arr[low]};
         count++;
         return new int[]{arr[low],arr[high]};
     }
    
         int mid = low + (high-low)/2;
         int [] case1 = getMinMax(arr, low, mid);
         int [] case2 = getMinMax(arr, mid+1,high);
         int min = Math.min(case1[0],case2[0]);
         count++;
         int max = Math.max(case1[1],case2[1]);
         count++;
         return new int[]{min,max};
     

}

public static void main(String args[]) {
        int arr[] = {10, 11, 45, 1, 30, 3};
        int arr_size = 6;
        int [] minmax = new int[2];
        minmax = getMinMax(arr, 0, arr_size - 1);
        System.out.printf("\nMinimum element is %d", minmax[0]);
        System.out.printf("\nMaximum element is %d", minmax[1]);
        System.out.printf("\nCount of comparison is %d", count);
 
 
    }

}