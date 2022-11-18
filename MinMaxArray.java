public class MinMax {
    class Pair {
 
        int min;
        int max;
    }
 
    public Pair getMinMax(int arr[], int low, int high)
    {
        Pair minmax = new Pair();
        Pair one = new Pair();
        Pair two = new Pair();
        int mid;
 
        if (low == high) {
            minmax.max = arr[low];
            minmax.min = arr[low];
            return minmax;
        }
 
        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                minmax.max = arr[low];
                minmax.min = arr[high];
            }
            else {
                minmax.max = arr[high];
                minmax.min = arr[low];
            }
            return minmax;
        }
 
        mid = (low + high) / 2;
        one = getMinMax(arr, low, mid);
        two = getMinMax(arr, mid + 1, high);
 
        if (one.min < two.min) {
            minmax.min = one.min;
        }
        else {
            minmax.min = two.min;
        }
 
        if (one.max > two.max) {
            minmax.max = one.max;
        }
        else {
            minmax.max = two.max;
        }
 
        return minmax;
    }
}