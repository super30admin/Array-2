// Time Complexity : O(n)
// Space Complexity : O(1)

class MaxMinOfArray{
    Stattic class Pair{
        int min;
        int max;
    }

    // to find the minimum and the maximum, we will be traversing in the pair
    public static Pair getMinMax(int[] arr, int n){
        Pair minmax = new Pair();
        int i;

        //for the even number of element, we will choose our min and max from first two element
        //and for the odd number of element, we will choose first element as our min and max both.
        if(n%2 ==0){
            if(arr[0]>arr[1]){
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.max = arr[1];
                minmax.min = arr[0];
            }
            i=2;
        } else {
            minmax.max = arr[0];
            minmax.min = arr[0];
            i=1;
        }

        // we will compare each pair of next element with each other first and the with our min and max
        while(i<n-1){

            if(arr[i]>arr[i+1]){
                if(arr[i]>minmax.max){
                    minmax.max = arr[i];
                }
                if(arr[i+1]<minmax.min){
                    minmax.min = arr[i+1];
                }
            } else {
                if(arr[i+1]>minmax.max){
                    minmax.max = arr[i+1];
                }
                if(arr[i]<minmax.min){
                    minmax.min = arr[i];
                }
            }
            i+=2;
        }

        return minmax;

    }
}