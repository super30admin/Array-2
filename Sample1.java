// Time Complexity :N+(n-2)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach:



public class Sample1{
    /* Class Pair is used to return two values from getMinMax() */
        static class Pair {
     
            int min;
            int max;
        }
     
        static Pair getMinMax(int arr[], int n) {
            Pair minmax = new  Pair();
            int i;
     
            /*If there is only one element then return it as min and max both*/
            if (n == 1) {
                minmax.max = arr[0];
                minmax.min = arr[0];
                return minmax;
            }
     
            // If there are more than one elements, then initialize min
       // and max
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.max = arr[1];
                minmax.min = arr[0];
            }
     // iterate from the 3rd element amd check of anythig is greater than maximum and if anything is lesses than miinmum
            for (i = 2; i < n; i++) {
                if (arr[i] > minmax.max) {
                    minmax.max = arr[i];
                } else if (arr[i] < minmax.min) {
                    minmax.min = arr[i];
                }
            }
     
            return minmax;
        }
     
        }
     
