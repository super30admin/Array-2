/* Min Max Problem
Time Complexity: O(n)
Space Complexity: O(1)
Pair wise comparison. In the pair, compare the greater element of the par with max and the 
lesser element with min */

import java.io.*;

class GFG {
    public static void main (String[] args) {
        int[] a = new int[] {2,4,1,5,11,7,0,6,13};
        int n= a.length;

        int min = a[0];
        int max = a[0];

        for(int i=0; i<n; i+=2){
            //Edge case for the last element in that array when there are odd Number of elements
            if(i == n-1){
                if(a[i] < min) min = a[i];
                if(a[i] > max) max = a[i];
            }
            else {
                if(a[i] > a[i+1]){
                    if(a[i] > max) max = a[i];
                    if(a[i+1] < min) min = a[i+1];
                }else{
                    if(a[i] < min) min = a[i];
                    if(a[i+1] > max) max = a[i+1];
                }
            }
        }
        System.out.print(max);
        System.out.print("****" + min);
    }
}