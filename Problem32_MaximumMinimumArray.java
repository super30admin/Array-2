// Time Complexity : O(n), n-> length of the array
// Space Complexity : O(1)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    class Pair {
        int max;
        int min;
    }
    public Pair getMinMax(int[] arr, int low, int high) {
        Pair minmax = new Pair();
        Pair mml = new Pair();
        Pair mmr = new Pair();
        int mid;

        if(low == high) {
            minmax.max = arr[low];
            minmax.min = arr[low];
            return minmax;
        }

        if(arr.length == 2) {
            if(arr[low] > arr[high]) {
                minmax.max = arr[low];
                minmax.min = arr[high];
            } else {
                minmax.max = arr[high];
                minmax.min = arr[low];
            }
        }

        mid = low + ((high - low) / 2);
        mml = getMinMax(arr, low, mid);
        mmr = getMinMax(arr, mid + 1, high);

        if(mml.min < mmr.min)
            minmax.min = mml.min;
        else
            minmax.min = mmr.min;
            
        if(mml.max < mmr.max) 
            minmax.max = mmr.max;
        else
            minmax.max = mml.max;

        return minmax;
    }
}