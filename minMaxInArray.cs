// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
using System;

namespace maxMinInArray
{
   class HelloWorld {
    static void Main() {
        int[] a = new int[]{-1, 2, 6, -5, 3, 1};
        int max, min;
        int index = 0;
        
        if(a.Length % 2 == 0) {
         
           if(a[0] > a[1]) {
               max = a[0];
               min = a[1];
           } else {
               max = a[1];
               min = a[0];
           }
           index = 2;
            
        } else {
            max = a[0];
            min = a[0];
            index = 1;
        }
        
        for(int i=index; i < a.Length; i = i + 2) {
            
            if(a[i] > a[i+1]) {
                max = Math.Max(a[i], max);
                min = Math.Min(a[i+1], min);
            } else {
                 min = Math.Min(a[i], min);
                 max = Math.Max(a[i+1], max);
            }
        }
        
        System.Console.WriteLine(min);
          System.Console.WriteLine(max);
    }
}
}
