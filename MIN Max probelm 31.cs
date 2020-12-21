using System;
     
class GFG 
{
 
    /* Class Pair is used to return 
       two values from getMinMax() */
    public class Pair 
    {
        public int min;
        public int max;
    }
 
    static Pair getMinMax(int []arr, int n)
    {
        Pair minmax = new Pair();
        int i;
         
        
        if (n % 2 == 0) 
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
        
        else
        {
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;
            /* set the starting index for loop */
        }
 
        /* In the while loop, pick elements in pair and 
        compare the pair with max and min so far */
        while (i < n - 1) 
        {
            if (arr[i] > arr[i + 1]) 
            {
                if (arr[i] > minmax.max) 
                {
                    minmax.max = arr[i];
                }
                if (arr[i + 1] < minmax.min)
                {
                    minmax.min = arr[i + 1];
                }
            } 
            else
            {
                if (arr[i + 1] > minmax.max)
                {
                    minmax.max = arr[i + 1];
                }
                if (arr[i] < minmax.min)
                {
                    minmax.min = arr[i];
                }
            }
            i += 2;
             
           
        }
        return minmax;
    }
 
    // Driver Code
    public static void Main(String []args) 
    {
        int []arr = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        Pair minmax = getMinMax(arr, arr_size);
        Console.Write("Minimum element is {0}",
                                   minmax.min);
        Console.Write("\nMaximum element is {0}", 
                                     minmax.max);
    }
}