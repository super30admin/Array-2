// Time Complexity : O(n) with comparisons = 3(n-1)/2 in case of odd; 3n/2-2 in case of even no of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* APPROACH:
Creating a pair having min and max elements.
If even no of elements, set the first and second element as min and max according to comparisons
If odd no of elements, set the first element as min and max

now until index hits n-1,
compare with 2 elements at a time, whichever is max of the two elements gets compared with max of the pair
whichever is minimum of the two gets compared with min of the paie
increase index by 2
 */

public class MaxAndMinArray {
    static class Pair {
        int min;
        int max;
    }

    static Pair getMinMax(int[] arr, int n){
        Pair minmax = new Pair();
        int i;

        // if array has even number of elements, we set the first and last element as min and max according to the comparison
        if(n%2 == 0){
            if(arr[0] > arr[1]){
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;
        }else{
            // array has odd elements, then set both min and max as this element itself
            minmax.max = arr[0];
            minmax.min = arr[0];
            i=1;
        }

        while(i < n-1){
            if(arr[i+1] > arr[i]){
                if(minmax.max < arr[i+1]){
                    minmax.max = arr[i+1];
                }
                if(minmax.min > arr[i]){
                    minmax.min = arr[i];
                }

            } else {
                if(minmax.max < arr[i]){
                    minmax.max = arr[i];
                }
                if(minmax.min > arr[i+1]){
                    minmax.min = arr[i+1];
                }
            }
            i+=2;
        }
        return minmax;
    }

    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax.min); //1
        System.out.printf("\nMaximum element is %d", minmax.max); //3000

    }

}
