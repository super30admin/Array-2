// Time Complexity : O(n)
// Space Complexity : O(1)

/*
 * get the min and max values at index 0 and 1 and compare the adjacent values
 * to get the min and max of the current and prevoius values.
 */

public class MinAndMaxOfArray {
    static class Pair{
        int min;
        int max;
    }
    public Pair getMinMax(int[] arr){
        Pair minMax = new Pair();
        if(arr.length == 1){
            minMax.min = minMax.max = arr[0];
            return minMax;
        }

        if(arr.length == 2){
            minMax.min = Math.min(arr[0], arr[1]);
            minMax.max = Math.max(arr[0], arr[1]);
            return minMax;
        }
        if(arr[0] > arr[1]){
            minMax.min = arr[1];
            minMax.max = arr[0];
        }
        else{
            minMax.min = arr[0];
            minMax.max = arr[1];
        }
        
        if(arr.length%2 == 0){
            for(int i = 2; i < arr.length; i+=2){
                if(arr[i] > arr[i+1]){
                    minMax.max = Math.max(arr[i], minMax.max);
                    minMax.min = Math.min(arr[i+1], minMax.min);
                }
                else{
                    minMax.max = Math.max(arr[i+1], minMax.max);
                    minMax.min = Math.min(arr[i], minMax.min);
                }
            }
        }
        else{
            for(int i = 2; i < arr.length-1; i+=2){
                if(arr[i] > arr[i+1]){
                    minMax.max = Math.max(arr[i], minMax.max);
                    minMax.min = Math.min(arr[i+1], minMax.min);
                }
                else{
                    minMax.max = Math.max(arr[i+1], minMax.max);
                    minMax.min = Math.min(arr[i], minMax.min);
                }
            }
            minMax.max = Math.max(arr[arr.length-1], minMax.max);
            minMax.min = Math.min(arr[arr.length-1], minMax.min);
        }
        return minMax;
    }

    public static void main(String[] args) {
        int arr[] = {32,5,64,42,323};
        MinAndMaxOfArray mn = new MinAndMaxOfArray();
        Pair p = mn.getMinMax(arr);
        System.out.println(p.min + " " + p.max);
    }
}