// Time Complexity : o(2(n-2)/2)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class MinMax {
    static class Pair {
        int max;
        int min;
    }
    static Pair getminmax(int[] arr, int arrsize)
    {
        Pair val = new Pair();
        if(arrsize %2 == 0)
        {
            val.max = Math.max(arr[0], arr[1]);
            val.min = Math.min(arr[0], arr[1]);
            for(int i =2 ; i < arrsize; i +=2)
            {
                val.min = Math.min(val.min, Math.min(arr[i], arr[i+1]));
                val.max = Math.max(val.max, Math.max(arr[i], arr[i+1]));
            }
        }
        else
        {
            val.min = arr[0];
            val.max = arr[0];
            for(int i =2 ; i < arrsize; i +=2)
            {
                val.min = Math.min(val.min, Math.min(arr[i], arr[i+1]));
                val.max = Math.max(val.max, Math.max(arr[i], arr[i+1]));
            }
        }
        return val;
    }
    public static void main (String[] args)
    {
     int[] arr = {1000, 11, 445, 1, 330, 3000};
     int arrsize = 6;
     Pair minmax = getminmax(arr, arrsize);
     System.out.println("The max element is " + minmax.max);
     System.out.println("The min element is " + minmax.min);
    }
}