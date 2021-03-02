// Time Complexity :O(3n/2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : (On github) yes
// Any problem you faced while coding this :No


public class MinMax {
    public static int[] getMinMax(int a[])
    {
        int n = a.length;
        int i = 0;
        int min  = 0;
        int max  = 0;
        if (n % 2 == 0) {
            if (a[0] > a[1]) {
                max = a[0];
                min = a[1];
            }
            else {
                max = a[1];
                min = a[0];
            }
            i = 2;
        }
        if (n % 2 == 1) {
            max = a[0];
            min = a[0];
            i = 1;
        }



        while (i < n - 1) {


            if (a[i] > a[i+1]) {
                max = Math.max(a[i], max);
                min = Math.min(a[i+1], min);
            }
            else {
                max = Math.max(a[i+1], max);
                min = Math.min(a[i], min);
            }

            i+=2;
        }


        return new int[] {min, max};
    }
}
