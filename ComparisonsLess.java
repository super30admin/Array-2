// Time Complexity : O(n) where n is the number of elements but with 1.5n comparisons < 2n- 4 comparisons
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was knowing the brute force approach only
/* Your code here along with comments explaining your approach: Take the numbers in a pair fashion. Compare among themselves to store the min 
and max. Compare the next element with both min and max. Repeat this for each element in the array.
*/
public class ComparisonsLess { 

    /* Class Pair is used to return two values from getMinMax() */
        static class Pair { 
            int min; 
            int max; 
        } 
    
        static Pair getMinMax(int arr[], int n) { 
            Pair pair = new Pair();
            pair.min = arr[0];
            pair.max = arr[0];                          // Random initialisation of pair
            for(int i = 0 ; i < arr.length-1; i+=2){
                if(arr[i] > arr[i+1]){                          // Compare the elements in a pair among itself
                    if(pair.min > arr[i+1]){                            // Compare whether we got the new min    
                        pair.min = arr[i+1];
                    } else 
                    if(pair.max < arr[i]){
                        pair.max = arr[i];                  // Whether we got a new max
                    }
                } else {
                    if(pair.min > arr[i]){                      // Vice Versa
                        pair.min = arr[i];
                    } else 
                    if(pair.max < arr[i+1]){
                        pair.max = arr[i+1];
                    }
                }
            }
            return pair;                                    // Return the pair of min and max
        }
        /* Driver program to test above function */
        public static void main(String args[]) { 
            int arr[] = {1000, 11, 445, 1, 330, 3000}; 
            int arr_size = 6; 
            Pair minmax = getMinMax(arr, arr_size); 
            System.out.printf("\nMinimum element is %d", minmax.min); 
            System.out.printf("\nMaximum element is %d", minmax.max); 
    
        } 
    } 
    