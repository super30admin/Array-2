/*
Time Complexity: O(n)
Auxiliary Space: O(1) as no extra space was needed.
Number of Comparisons:
If n is odd:    3*(n-1)/2

If n is even:   1 + 3*(n-2)/2 = 3n/2-2, 1 comparison for initializing min and max,
                      and 3(n-2)/2 comparisons for rest of the elements
 */

public class FindMinAndMaxofAnArray {
    //Maximum and minimum of an array by comparing in pairs
    /*
    The idea is that when n is odd then initialize min and max as the first element. If n is even then initialize min
    and max as minimum and maximum of the first two elements respectively. For the rest of the elements, pick them in
    pairs and compare their maximum and minimum with max and min respectively.
     */

    /* Driver program to test above function */
    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int[] output = getMinMax(arr);
        System.out.println("Minimum element is " +  output[0]);
        System.out.println("Maximum element is " + output[1]);
    }

    private static int[] getMinMax(int[] arr) {
        int[] output = new int[2];
        int i;

        /* If array has even number of elements then
    initialize the first two elements as minimum and
    maximum */

        if(arr.length % 2 == 0){
            if(arr[0] > arr[1]){
                output[1] = arr[0]; //output[1] is max
                output[0] = arr[1]; //output[0] is min
            } else {
                output[0] = arr[0];
                output[1] = arr[1];
            }

            i = 2; //set starting indec for loop
        } else { //if odd length input
            output[1] = arr[0]; //output[1] is max
            output[0] = arr[0]; //output[0] is min
            i = 1;
        }

         /* In the while loop, pick elements in pair and
     compare the pair with max and min so far */

     while(i < (arr.length - 1)){
         if(arr[i] > arr[i+1]){

             if(arr[i] > output[1]){
                 output[1] = arr[i];
             }

             if(arr[i+1] < output[0]){
                 output[0] = arr[i+1];
             }
         } else {

             if(arr[i+1] > output[1]){
                 output[1] = arr[i+1];
             }

             if(arr[i] < output[0]){
                 output[0] = arr[i];
             }

         }
         i = i+2;
     }


        return output;
    }
}
