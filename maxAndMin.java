// Time Complexity : O(N)
// Space Complexity : O(1)

class Solution{

    class Pair{
        int min;
        int max;
    }

    public Pair maxAndMin(int[] arr) {     
        Pair pair = getMinMax(arr, 0, arr.length - 1);
        return new int[0];
    }

    static Pair getMinMax(int[] arr, int low, int high) {

        Pair minMax = new Pair();
        Pair minl = new Pair();
        Pair minr = new Pair();

        if(low == high) {
            minMax.min = arr[low];
            minMax.max = arr[low];

            return minMax;
        }

        if(low == high - 1) {
            if(arr[low] <= arr[high]){
                minMax.min = arr[low];
                minMax.max = arr[high];
            }
            else{
                minMax.min = arr[high];
                minMax.max = arr[low];
            }

            return minMax;
        }

        int mid = low + (high - low) / 2;

        minl = getMinMax(arr, low, mid);
        minr = getMinMax(arr, mid + 1, high);

        minMax.min = Math.min(minl.min, minr.min);
        minMax.max = Math.max(minr.max, minl.max);

        return minMax;
    }

}

