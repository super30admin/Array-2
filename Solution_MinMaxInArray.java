//TC: O(n)
//SC: O(1)
//Did it run on leetcode: Yes
public class Solution_MinMaxInArray {
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        // Code Here
        int n = arr.length;
        if(n == 1){
            return new Pair(arr[0], arr[0]);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int i = 0;
        while(i < n-1){
            if(arr[i] > arr[i+1]){
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i+1]);
            } else {
                max = Math.max(max, arr[i+1]);
                min = Math.min(min, arr[i]);
            }
            i += 2;
        }
        if(i < n){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return new Pair(min, max);
    }
}
